package com.example.plantstore.plantstore.screen.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plantstore.plantstore.domain.CategoryModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.viewModel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onOpenDetail: (PlantModel) -> Unit,
    onCartClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val categories = remember { mutableStateListOf<CategoryModel>() }
    val popularPlant = remember { mutableStateListOf<PlantModel>() }
    val newPlant = remember { mutableStateListOf<PlantModel>() }

    var showCategoryLoading by remember { mutableStateOf(true) }

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
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadNewPlant().observeForever {
            newPlant.clear()
            newPlant.addAll(it)
        }
    }

    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {
            item { TopBar(
                onCartClick = {},
                onSettingsClick = {}
            ) }
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
        viewModel = viewModel,
        onOpenDetail = {},
        onCartClick = {},
        onSettingsClick = {}
    )
}