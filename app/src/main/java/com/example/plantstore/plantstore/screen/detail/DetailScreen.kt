package com.example.plantstore.plantstore.screen.detail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant

@Composable
fun DetailScreen(
    item: PlantModel,
    onBack: () -> Unit
) {
    Scaffold(
        containerColor = Color.White,
        bottomBar = { DetailBottomBar(item.Price) }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {


            item {
                DetailHeader(
                    onBack = onBack,
                    onCart = {},
                    onSetting = {}
                )
            }

            item {
                DetailName(
                    item = item
                )
            }


            item {
                DetailImage(
                    imagePath = item
                )
            }

            item {
                DetailBody(
                    item = item
                )
            }

        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    val item = previewPlant
    DetailScreen(
        item = item,
        onBack = {}
    )
}