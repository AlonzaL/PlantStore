package com.example.plantstore.plantstore.navigation

import androidx.navigation.NavController
import com.example.plantstore.plantstore.Domain.PlantModel

fun NavController.navDetail(
    plant: PlantModel
) {
    currentBackStackEntry?.savedStateHandle?.set("plant", plant)
    navigate(Screen.Detail.route)
}