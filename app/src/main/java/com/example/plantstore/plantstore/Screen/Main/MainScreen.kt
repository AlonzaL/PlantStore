package com.example.plantstore.plantstore.Screen.Main

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.plantstore.plantstore.Domain.CategoryModel
import com.example.plantstore.plantstore.Domain.PlantModel
import com.example.plantstore.plantstore.ViewModel.MainViewModel

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    val viewModel = MainViewModel()

    val categories = remember { mutableStateListOf<CategoryModel>() }
    val popularPlant = remember { mutableStateListOf<PlantModel>() }
    val newPlant = remember { mutableStateListOf<PlantModel>() }

    var showCategoryLoading by remember { mutableStateOf(true) }
    var showPopularPlantLoading by remember { mutableStateOf(true) }
    var showNewPlantLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        viewModel.loadCategory().observeForever {
            categories.clear()
            categories.addAll(it)
            showCategoryLoading = false
        }
    }
}