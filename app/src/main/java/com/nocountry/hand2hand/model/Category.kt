package com.nocountry.hand2hand.model

data class Category(
    var name: String,
    var icon: String,
    var subcategories: List<SubCategory>
)