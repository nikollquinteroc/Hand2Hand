package com.nocountry.hand2hand.ui.screens.create_product

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.data.model.firebase.Category
import com.nocountry.hand2hand.data.model.firebase.Product
import com.nocountry.hand2hand.data.model.firebase.State
import com.nocountry.hand2hand.ui.components.ButtonComponent
import com.nocountry.hand2hand.ui.components.ImagePicker
import com.nocountry.hand2hand.ui.components.SpacerComponent
import com.nocountry.hand2hand.ui.components.TitleComponent
import com.nocountry.hand2hand.ui.components.TopAppBarComponent
import com.nocountry.hand2hand.ui.screens.ErrorScreen
import com.nocountry.hand2hand.ui.screens.product_created.ProductCreatedScreen

@Composable
fun CreateProductScreen(
    createProductViewModel: CreateProductViewModel = viewModel(factory = CreateProductViewModel.provideFactory()),
    navigateUp: () -> Unit,
    navigateHome: () -> Unit
) {

    val uiState by createProductViewModel.uiState.collectAsState()
    val state = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBarComponent(
                titleScreen = R.string.new_product,
                onClickBack = navigateUp
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(state)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when {
                    uiState.isLoading -> {
                        CircularProgressIndicator()
                    }

                    uiState.error.isNotEmpty() -> {
                        ErrorScreen(navigateUp = navigateUp)
                    }

                    uiState.data.createdProductMessage.isNotEmpty() -> {
                        ProductCreatedScreen(
                            navigateToHome = navigateHome,
                            message = uiState.data.createdProductMessage
                        )
                    }

                    uiState.data.categories.isNotEmpty() && uiState.data.states.isNotEmpty() -> {
                        FormCreateProduct(
                            createProductViewModel = createProductViewModel,
                            categories = uiState.data.categories,
                            states = uiState.data.states,
                            navigateUp = navigateUp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FormCreateProduct(
    createProductViewModel: CreateProductViewModel,
    categories: List<Category>,
    states: List<State>,
    navigateUp: () -> Unit
) {

    val selectedImagesUris = remember { mutableStateOf<List<Uri>>(emptyList()) }

    val multipleImagePickerLauncher =
        rememberLauncherForActivityResult(PickMultipleVisualMedia()) { uri ->
            selectedImagesUris.value = uri
        }

    TitleComponent(text = "Completa todos los campos", style = MaterialTheme.typography.bodyLarge)
    SpacerComponent(modifier = Modifier.height(20.dp))
    TitleComponent(text = "Añadir las fotos", style = MaterialTheme.typography.bodySmall)
    SpacerComponent()
    ImagePicker(multipleImagePickerLauncher)
    LazyRow {
        items(selectedImagesUris.value) { imageUri ->
            AsyncImage(
                model = imageUri,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(60.dp, 60.dp)
            )
        }
    }
    SpacerComponent(modifier = Modifier.height(25.dp))
    FormFields(categories, states)
    SpacerComponent(modifier = Modifier.height(30.dp))
    ButtonComponent(
        text = stringResource(id = R.string.publish_product),
        backgroundColorButton = Color(0xFF6F50E9),
        onClick = {
            val product = buildProductData(
                categoryId = "AWVsAtQGK84i1VVE6RmR",
                description = "Esto es una descripcion de prueba",
                discountedPrice = null,
                name = "Nombre de prueba",
                pictures = listOf("https://firebasestorage.googleapis.com/v0/b/hand2hand-1142f.appspot.com/o/goku.jpg?alt=media&token=9add1ddf-056f-4a32-b0bb-3859e841a723"),
                price = 2400000,
                stateId = "rEDaexRgU9OjnRiGOKtJ"
            )

            createProductViewModel.saveProduct(product)
        }
    )
    SpacerComponent(modifier = Modifier.height(30.dp))
}

private fun buildProductData(
    categoryId: String,
    description: String,
    discountedPrice: Int?,
    name: String,
    pictures: List<String>,
    price: Int,
    stateId: String
): Product {
    return Product(
        categoryId = categoryId,
        description = description,
        discountPrice = discountedPrice ?: 0,
        name = name,
        pictures = pictures,
        price = price,
        stateId = stateId
    )
}

@Preview(showBackground = true)
@Composable
fun NewProductPreview() {
    MaterialTheme {
        val createProductViewModel: CreateProductViewModel =
            viewModel(factory = CreateProductViewModel.provideFactory())
        val state = rememberScrollState()
        //CreateProductScreen(viewModel(factory = CreateProductViewModel.provideFactory()), {}, {})
        FormCreateProduct(
            createProductViewModel = createProductViewModel,
            categories = emptyList(),
            states = emptyList(),
            navigateUp = {})
    }
}