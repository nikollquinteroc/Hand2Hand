package com.nocountry.hand2hand.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.nocountry.hand2hand.data.model.firebase.Product
import com.nocountry.hand2hand.domain.ProductRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ProductRepositoryImpl(val firebase: FirebaseFirestore) : ProductRepository {
    override suspend fun getProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductById(id: String): Flow<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun saveProduct(product: Product): Flow<String> = callbackFlow {
        firebase.collection("products").add(product)
            .addOnSuccessListener { trySend("Tu producto ha sido publicado exitosamente") }
            .addOnFailureListener { trySend("Error al guardar tu producto") }

        awaitClose { }
    }
}


