package com.example.plantstore.plantstore.screen.listPlant

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant
import com.example.plantstore.plantstore.screen.main.PlantCard

@Composable
fun ListPlant(
    items: List<PlantModel>,
    onDetailClick: (PlantModel) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(items) { item ->
            PlantCard(
                item = item,
                onClick = { onDetailClick(item) }
            )
        }
    }
}

@Preview
@Composable
fun ListPlantPreview() {
    val items = listOf(
        previewPlant,
        previewPlant
    )
    ListPlant(
        items = items,
        onDetailClick = {}
    )
}