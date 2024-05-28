package com.nocountry.hand2hand.data

import androidx.annotation.DrawableRes

data class Category(
    var name: String,
    @DrawableRes var icon: Int,
    var subcategories: List<SubCategory>
)
