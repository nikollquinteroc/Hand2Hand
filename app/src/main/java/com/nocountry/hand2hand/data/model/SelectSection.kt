package com.nocountry.hand2hand.data.model


data class SelectSection(
    override val name: String,
    override val label: String,
    val options: List<Int>
) : NewSection
