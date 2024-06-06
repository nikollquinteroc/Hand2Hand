package com.nocountry.hand2hand.model

import com.nocountry.hand2hand.R

data class CategoryRepository(
    val icon: Int,
    val name: String
)

val categories: List<CategoryRepository> = listOf(
    CategoryRepository(icon = R.drawable.component_110 , name = "Cuidados y belleza"),
    CategoryRepository(icon = R.drawable.component_113, name = "Hogar"),
    CategoryRepository(icon = R.drawable.component_106 , name = "Moda"),
    CategoryRepository(icon = R.drawable.component_115, name = "Bebés"),
    CategoryRepository(icon = R.drawable.component_109, name = "Mascotas"),
    CategoryRepository(icon = R.drawable.component_107 , name = "Construcción"),
    CategoryRepository(icon = R.drawable.component_110 , name = "Cuidados y belleza"),
    CategoryRepository(icon = R.drawable.component_113, name = "Hogar"),
    CategoryRepository(icon = R.drawable.component_106 , name = "Moda"),
    CategoryRepository(icon = R.drawable.component_115, name = "Bebés"),
    CategoryRepository(icon = R.drawable.component_109, name = "Mascotas"),
    CategoryRepository(icon = R.drawable.component_107 , name = "Construcción"),
    /*CategoryRepository(icon = R.drawable.component_108, name = "Jardín"),
    CategoryRepository(icon = R.drawable.component_111, name = "Electrónica"),
    CategoryRepository(icon = R.drawable.component_112 , name = "Gamer"),
    CategoryRepository(icon = R.drawable.component_114, name = "Juguetes"),
    CategoryRepository(icon = R.drawable.component_110 , name = "Cuidados y belleza"),
    CategoryRepository(icon = R.drawable.component_113, name = "Hogar"),
    CategoryRepository(icon = R.drawable.component_106 , name = "Moda"),
    CategoryRepository(icon = R.drawable.component_115, name = "Bebés"),
    CategoryRepository(icon = R.drawable.component_109, name = "Mascotas"),
    CategoryRepository(icon = R.drawable.component_107 , name = "Construcción"),
    CategoryRepository(icon = R.drawable.component_108, name = "Jardín"),
    CategoryRepository(icon = R.drawable.component_111, name = "Electrónica"),
    CategoryRepository(icon = R.drawable.component_112 , name = "Gamer"),
    CategoryRepository(icon = R.drawable.component_114, name = "Juguetes"),*/
)

data class CardRepository(
    val image: Int,
    val name: String,
    val price: String,
    val realPrice: String,
    val description: String
)

val cards: List<CardRepository> = listOf(
    CardRepository(R.drawable.image_01, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_02, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_03, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_04, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_05, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_06, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_07, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_08, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_09, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_01, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
    CardRepository(R.drawable.image_02, "Sillón vintage", "$20.000", "$45.000", "Seminuevo"),
)

data class SectionRepository(
    val name: String
)

val sections: List<SectionRepository> = listOf(
    SectionRepository("Subastas del día"),
    SectionRepository("Productos del día"),
    SectionRepository("Ofertas del día"),
    SectionRepository("Productos del día"),
)
