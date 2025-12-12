package com.example.plantstore.plantstore.domain

import com.google.firebase.firestore.PropertyName
import java.io.Serializable

data class PlantModel(
    @get:PropertyName("id") @set:PropertyName("id")
    var id: Int = 0,
    @get:PropertyName("title") @set:PropertyName("title")
    var title: String = "",
    @get:PropertyName("category") @set:PropertyName("category")
    var category: String = "",
    @get:PropertyName("description") @set:PropertyName("description")
    var description: String = "",
    @get:PropertyName("price") @set:PropertyName("price")
    var price: Double = 0.0,
    @get:PropertyName("heightFlower") @set:PropertyName("heightFlower")
    var heightFlower: String = "",
    @get:PropertyName("potSize") @set:PropertyName("potSize")
    var potSize: String = "",
    @get:PropertyName("potType") @set:PropertyName("potType")
    var potType: String = "",
    @get:PropertyName("iImagePath") @set:PropertyName("imagePath")
    var imagePath: List<String> = emptyList<String>(),
    val isFavorite: Boolean = false,
    @get:PropertyName("popularPlant")
    val isPopular: Boolean = false,
    @get:PropertyName("newPlant")
    val isNew: Boolean = false,
    @get:PropertyName("numberInCart") @set:PropertyName("numberInCart")
    var numberInCart: Int = 0
) : Serializable