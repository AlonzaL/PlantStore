package com.example.plantstore.plantstore.domain

import com.google.firebase.firestore.PropertyName
import java.io.Serializable

data class PlantModel(
    @get:PropertyName("Id")
    val id: Int = 0,
    @get:PropertyName("Title")
    val title: String = "",
    @get:PropertyName("Category")
    val category: String = "",
    @get:PropertyName("Description")
    val description: String = "",
    @get:PropertyName("Price")
    val price: Double = 0.0,
    @get:PropertyName("HeightFlower")
    val heightFlower: String = "",
    @get:PropertyName("PotSize")
    val potSize: String = "",
    @get:PropertyName("PotType")
    val potType: String = "",
    @get:PropertyName("ImagePath")
    val imagePath: List<String> = emptyList<String>(),
    val isFavorite: Boolean = false,
    @get:PropertyName("PopularPlant")
    val isPopular: Boolean = false,
    @get:PropertyName("NewPlant")
    val isNew: Boolean = false,
    val numberInCart: Int = 0
) : Serializable