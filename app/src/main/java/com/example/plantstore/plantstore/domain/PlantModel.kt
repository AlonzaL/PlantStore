package com.example.plantstore.plantstore.domain

import java.io.Serializable

data class PlantModel(
    var id: Int = 0,
    var title: String = "",
    var category: String = "",
    var description: String = "",
    var price: Double = 0.0,
    var priceId: Int = 0,
    var heightFlower: String = "",
    var potSize: String = "",
    var potType: String = "",
    var imagePath: List<String> = emptyList<String>(),
    var isFavorite: Boolean = false,
    var isPopular: Boolean = false,
    var isNew: Boolean = false,
    var numberInCart: Int = 0
) : Serializable