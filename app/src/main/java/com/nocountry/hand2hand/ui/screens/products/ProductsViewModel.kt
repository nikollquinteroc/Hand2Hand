package com.nocountry.hand2hand.ui.screens.products

import androidx.lifecycle.ViewModel
import com.nocountry.hand2hand.data.model.firebase.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ProductsUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val isError: String = ""
)

class ProductsViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<ProductsUiState> = MutableStateFlow(ProductsUiState())
    val uiState: StateFlow<ProductsUiState> = _uiState
}