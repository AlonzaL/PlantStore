package com.example.plantstore.plantstore.helper

import com.example.plantstore.R
import com.example.plantstore.plantstore.domain.PlantModel

val previewPlant = PlantModel(
    Id = 1,
    Title = "Plant",
    Category = "Indoor",
    Description = "la la la",
    Price = 23.5,
    PriceId = 1,
    HeightFlower = "2ft.",
    PotSize = "6 Inches",
    PotType = "Ceramic",
    ImagePath = listOf("R.drawable.flower_1", "R.drawable.flower_2"),
    isFavorite = false,
    PopularPlant = false,
    NewPlant = false,
    numberInCart = 1
)