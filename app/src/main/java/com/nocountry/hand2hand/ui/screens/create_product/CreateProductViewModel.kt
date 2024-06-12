package com.nocountry.hand2hand.ui.screens.create_product

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.firestore.FirebaseFirestore
import com.nocountry.hand2hand.data.model.firebase_firestore.Category
import com.nocountry.hand2hand.data.model.firebase_firestore.Product
import com.nocountry.hand2hand.data.model.firebase_firestore.State
import com.nocountry.hand2hand.data.repository.CategoryRepositoryImpl
import com.nocountry.hand2hand.data.repository.ProductRepositoryImpl
import com.nocountry.hand2hand.data.repository.StateRepositoryImpl
import com.nocountry.hand2hand.domain.CategoryRepository
import com.nocountry.hand2hand.domain.ProductRepository
import com.nocountry.hand2hand.domain.StateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CreateProductUiState(
    val isLoading: Boolean = false,
    val data: CreateProductData = CreateProductData(),
    val error: String = ""
)

data class CreateProductData(
    val categories: List<Category> = emptyList(),
    val states: List<State> = emptyList(),
    val createdProductMessage: String = ""
)

class CreateProductViewModel(
    savedStateHandle: SavedStateHandle,
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val stateRepository: StateRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<CreateProductUiState> =
        MutableStateFlow(CreateProductUiState())
    val uiState: StateFlow<CreateProductUiState> = _uiState.asStateFlow()

    init {
        getInitialData()
    }

    fun saveProduct(product: Product) {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            try {
                productRepository.saveProduct(product).collect { message ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            data = CreateProductData(createdProductMessage = message)
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = "Error guardando el producto en base de datos ${e.message}"
                    )
                }
            }
        }
    }


    private fun getInitialData() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            try {
                val categories = categoryRepository.getCategories().first()
                val states = stateRepository.getStates().first()

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        data = CreateProductData(
                            categories = categories,
                            states = states
                        )
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = "Error obteniendo las categorias y estados de la base de datos ${e.message}"
                    )
                }
            }
        }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val savedStateHandle = extras.createSavedStateHandle()

                return CreateProductViewModel(
                    savedStateHandle,
                    ProductRepositoryImpl(FirebaseFirestore.getInstance()),
                    CategoryRepositoryImpl(FirebaseFirestore.getInstance()),
                    StateRepositoryImpl(FirebaseFirestore.getInstance())
                ) as T
            }
        }
    }
}