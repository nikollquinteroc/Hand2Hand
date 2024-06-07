package com.nocountry.hand2hand.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.nocountry.hand2hand.data.model.firebase.Category
import com.nocountry.hand2hand.domain.CategoryRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class CategoryRepositoryImpl(val firebase: FirebaseFirestore) : CategoryRepository {
    override suspend fun getCategories(): Flow<List<Category>> = callbackFlow {
        firebase.collection("categories")
            .get()
            .addOnSuccessListener { result ->
                val categories = mutableListOf<Category>()
                for (category in result.documents) {
                    category.toObject(Category::class.java)?.let { categories.add(it) }
                }
                trySend(categories)
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error al obtener las categorias: ", exception)
            }

        awaitClose { }
    }
}