package com.example.plantstore.plantstore.Domain

import java.io.Serializable

data class PlantModel(
    var Id: Int = 0,
    var Title: String = "",
    var CategoryId: String = "",
    var Description: String = "",
    var Price: Double = 0.0,
    var PriceId: Int = 0,
    var HeightFlower: String = "",
    var PotSize: String = "",
    var PotType: String = "",
    var ImagePath: String = "",
    var isFavorite: Boolean = false,
    var PopularPlant: Boolean = false,
    var NewPlant: Boolean = false,
    var numberInCart: Int = 0
) : Serializable