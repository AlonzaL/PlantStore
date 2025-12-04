package com.example.plantstore.plantstore.screen.detail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant
import com.example.plantstore.plantstore.screen.detail.components.DetailBody
import com.example.plantstore.plantstore.screen.detail.components.DetailBottomBar
import com.example.plantstore.plantstore.screen.detail.components.DetailHeader
import com.example.plantstore.plantstore.screen.detail.components.DetailImage
import com.example.plantstore.plantstore.screen.detail.components.DetailName

@Composable
fun DetailScreen(
    item: PlantModel,
    onBack: () -> Unit
) {
    Scaffold(
        containerColor = Color.White,
        bottomBar = { DetailBottomBar(item.price) }
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
                    imagePath = item.imagePath[1]
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