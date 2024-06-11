package com.nocountry.hand2hand.domain

import com.nocountry.hand2hand.data.model.firebase.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts() : Flow<List<Product>>
    suspend fun getProductById(id: String) : Flow<Product>
    suspend fun saveProduct(product: Product) : Flow<String>
}