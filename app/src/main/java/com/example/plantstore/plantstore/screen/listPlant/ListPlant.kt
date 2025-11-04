package com.example.plantstore.plantstore.screen.listPlant

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant
import com.example.plantstore.plantstore.screen.main.PlantCard

@Composable
fun ListPlant(
    items: List<PlantModel>,
    onDetailClick: (PlantModel) -> Unit
) {
    LazyVerticalGrid(
        // Указываем, что хотим ровно 2 колонки
        columns = GridCells.Fixed(2),
        // Добавляем отступы вокруг всей сетки
        contentPadding = PaddingValues(30.dp)
    ) {
        // items() работает так же, как в LazyColumn
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
        previewPlant, previewPlant, previewPlant, previewPlant, previewPlant, previewPlant, previewPlant
    )
    ListPlant(
        items = items,
        onDetailClick = {}
    )
}