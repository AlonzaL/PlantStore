package com.example.plantstore.plantstore.screen.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.plantstore.plantstore.screen.main.components.CategorySection
import com.example.plantstore.plantstore.screen.main.components.PlantSection
import com.example.plantstore.plantstore.screen.main.components.SearchSection
import com.example.plantstore.plantstore.screen.main.components.HeaderSection
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
    val categories = listOf(
        "Indoor",
        "Outdoor",
        "Artificial"
    )

    val popularPlant by viewModel.listPopularPlant.collectAsState()
    val newPlant by viewModel.listNewPlant.collectAsState()

    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .padding(30.dp)
        ) {
            item {
                TopBar(
                    onCartClick = {},
                    onSettingsClick = onSettingsClick
                )
                //Spacer(modifier = Modifier.height(5.dp))
            }

            item {
                CategorySection(
                    categories = categories
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                SearchSection()
                Spacer(modifier = Modifier.height(12.dp))
            }
            item {
                HeaderSection(
                    title = "Popular product",
                    onSeeAll = onSeeAllPopular
                )
            }
            item {
                PlantSection(
                    items = popularPlant,
                    onClick = onOpenDetail
                )
            }
            item {
                HeaderSection(
                    title = "New product",
                    onSeeAll = onSeeAllNew
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
        onSettingsClick = {},
        onSeeAllNew = {},
        onSeeAllPopular = {}
    )
}