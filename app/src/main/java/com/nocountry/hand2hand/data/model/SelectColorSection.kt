package com.nocountry.hand2hand.data.model

data class SelectColorSection(
    override val name: String,
    override val label: String,
    val options: List<Pair<Int, Int>>
) : NewSection
