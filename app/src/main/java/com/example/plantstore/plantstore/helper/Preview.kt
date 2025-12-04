package com.example.plantstore.plantstore.helper

import com.example.plantstore.plantstore.domain.PlantModel

val previewPlant = PlantModel(
    id = 1,
    title = "Plant",
    category = "Indoor",
    description = "la la la",
    price = 23.5,
    heightFlower = "2ft.",
    potSize = "6 Inches",
    potType = "Ceramic",
    imagePath = listOf("R.drawable.flower_1", "R.drawable.flower_2"),
    isFavorite = false,
    isPopular = false,
    isNew = false,
    numberInCart = 1
)