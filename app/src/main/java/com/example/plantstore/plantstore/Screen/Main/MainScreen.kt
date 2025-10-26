package com.example.plantstore.plantstore.Screen.Main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plantstore.plantstore.Domain.CategoryModel
import com.example.plantstore.plantstore.Domain.PlantModel
import com.example.plantstore.plantstore.ViewModel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onOpenDetail: (PlantModel) -> Unit
) {
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

    LaunchedEffect(Unit) {
        viewModel.loadPopularPlant().observeForever {
            popularPlant.clear()
            popularPlant.addAll(it)
            showPopularPlantLoading = false
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadNewPlant().observeForever {
            newPlant.clear()
            newPlant.addAll(it)
            showNewPlantLoading = false
        }
    }

    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {
            item { TopBar() }
            item {
                CategorySection(
                    categories = categories,
                    showCategoryLoading = showCategoryLoading
                )
            }
            item {
                SectionHeader(
                    title = "Popular product",
                    onSeeAll = {}
                )
            }
            item {
                PlantSection(
                    items = popularPlant,
                    onClick = onOpenDetail
                )
            }
            item {
                SectionHeader(
                    title = "New product",
                    onSeeAll = {}
                )
            }
            item {
                PlantSection(
                    items = newPlant,
                    onClick = onOpenDetail
                )
            }
        }

    }
}

@Preview
@Composable
fun MainScreenPreview() {
    val viewModel: MainViewModel = viewModel()
    MainScreen(
        viewModel,
        onOpenDetail = {}
    )
}