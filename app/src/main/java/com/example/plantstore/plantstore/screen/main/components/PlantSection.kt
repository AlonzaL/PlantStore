package com.example.plantstore.plantstore.screen.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant

@Composable
fun PlantSection(
    items: List<PlantModel>,
    onClick: (PlantModel) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        if (items.isEmpty()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items.take(3)) { item ->
                    PlantCard(
                        item = item,
                        onClick = { onClick(item) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PlantSectionPreview() {
    val items = listOf(
        previewPlant,
        previewPlant,
        previewPlant,
        previewPlant,
        previewPlant,
        previewPlant,
        previewPlant
    )
    PlantSection(
        items = items,
        onClick = {}
    )
}