package com.example.plantstore.plantstore.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.screen.main.components.CategorySelector
import com.example.plantstore.plantstore.screen.main.components.HeaderSection
import com.example.plantstore.plantstore.screen.main.components.PlantCard
import com.example.plantstore.plantstore.screen.main.components.SearchBar
import com.example.plantstore.plantstore.screen.main.components.TopBar
import com.example.plantstore.plantstore.viewModel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onOpenDetail: (PlantModel) -> Unit,
    onCartClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onSeeAllPopular: () -> Unit,
    onSeeAllNew: () -> Unit
) {
    val popularPlants by viewModel.listPopularPlant.collectAsState()
    val newPlants by viewModel.listNewPlant.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()

    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                TopBar(
                    userName = "Alina",
                    onCartClick = onCartClick,
                    onSettingsClick = onSettingsClick
                )
            }

            item {
                CategorySelector(
                    categories = viewModel.categories,
                    selectedCategory = selectedCategory,
                    onCategoryClick = viewModel::onCategorySelect
                )
            }

            item {
                SearchBar(
                    value = searchQuery,
                    onValueChange = viewModel::onSearchQueryChange
                )
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    HeaderSection(
                        title = "Popular products",
                        onSeeAll = onSeeAllPopular
                    )
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(popularPlants) { plant ->
                            PlantCard(item = plant, onClick = { onOpenDetail(plant) })
                        }
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    HeaderSection(
                        title = "New arrivals",
                        onSeeAll = onSeeAllNew
                    )
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(newPlants) { plant ->
                            PlantCard(item = plant, onClick = { onOpenDetail(plant) })
                        }
                    }
                }
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
        onSettingsClick = {},
        onSeeAllNew = {},
        onSeeAllPopular = {}
    )
}