package com.nocountry.hand2hand.data.model.firebase

data class Product(
    val categoryId: String,
    val description: String,
    val discountPrice: Int,
    val name: String,
    val pictures: List<String>,
    val price: Int,
    val stateId: String
)
