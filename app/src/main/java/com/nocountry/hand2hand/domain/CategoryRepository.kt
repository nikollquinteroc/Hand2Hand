package com.nocountry.hand2hand.domain

import com.nocountry.hand2hand.data.model.firebase_firestore.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories() : Flow<List<Category>>
}