package com.nocountry.hand2hand.data.repository.local

import com.nocountry.hand2hand.R
import com.nocountry.hand2hand.data.model.SelectColorSection
import com.nocountry.hand2hand.data.model.SelectSection
import com.nocountry.hand2hand.data.model.WritingSection


val selectSection: List<SelectSection> = listOf(
    SelectSection(
        name = "Categoría",
        label = "Seleccionar la categoría",
        options = listOf(
            R.string.home_category,
            R.string.electronic_category,
            R.string.beauty_category,
            R.string.toy_category,
            R.string.garden_category,
            R.string.children_category,
            R.string.fashion_category,
            R.string.gamer_category,
        ),
    ),
    SelectSection(
        name = "Sub categoría",
        label = "Seleccionar la sub categoría",
        options = listOf(
            R.string.home_office_sub_category,
            R.string.living_room_sub_category,
            R.string.bedroom_sub_category,
            R.string.dining_room_sub_category,
            R.string.kitchen_sub_category,
            R.string.bathroom_sub_category,
            R.string.garden_sub_category,
            R.string.decoration_sub_category,
            R.string.storage_sub_category,
            R.string.light_point_sub_category,
        )
    ),
    SelectSection(
        name = "Especificar ítems",
        label = "Seleccionar los ítems",
        options = listOf(
            R.string.desk_item,
            R.string.office_chair_item,
            R.string.shelving_item,
            R.string.filing_cabinets_item,
            R.string.desk_organizers_item,
            R.string.desk_lamps_item,
            R.string.doilies_item,
            R.string.office_sofas_item,
            R.string.side_tables_item,
            R.string.slates_corks_item,
        )
    ),
    SelectSection(
        name = "Estado",
        label = "Seleccionar el estado",
        options = listOf(
            R.string.new_state,
            R.string.semi_new_state,
            R.string.used_state,
        )
    ),
    SelectSection(
        name = "Material",
        label = "Seleccionar el material",
        options = listOf(
            R.string.wood_material,
            R.string.metal_material,
            R.string.glass_material,
            R.string.plastic_material,
            R.string.velvet_material,
            R.string.leather_material,
            R.string.marble_material,
            R.string.ceramics_material,
            R.string.stone_material,
            R.string.resin_material,
            R.string.aluminum_material,
            R.string.teflon_material,
            R.string.latex_material,
            R.string.microfiber_material,
            R.string.polypropylene_material,
        )
    ),
    SelectSection(
        name = "Elegí la categoría de venta de tu producto",
        label = "Seleccionar la categoria de venta",
        options = listOf(
            R.string.fixed_price,
            R.string.auction
        )
    ),
)


val colorSection: SelectColorSection = SelectColorSection(
    name = "Color",
    label = "Seleccionar el color",
    options = listOf(
        Pair(R.drawable.blue, R.string.blue),
        Pair(R.drawable.yellow, R.string.yellow),
        Pair(R.drawable.beige, R.string.beige),
        Pair(R.drawable.white, R.string.white),
        Pair(R.drawable.gray, R.string.gray),
        Pair(R.drawable.brown, R.string.brown),
        Pair(R.drawable.orange, R.string.orange),
        Pair(R.drawable.black, R.string.black),
        Pair(R.drawable.red, R.string.red),
        Pair(R.drawable.pink, R.string.pink),
        Pair(R.drawable.green, R.string.green),
        Pair(R.drawable.violet, R.string.violet),
    )
)

val writingSection: List<WritingSection> = listOf(
    WritingSection(
        name = "Titulo de la publicación",
        label = "Escribe el título de tu producto"
    ),
    WritingSection(
        name = "Descripción del producto",
        label = "Describe tu producto"
    )
)



