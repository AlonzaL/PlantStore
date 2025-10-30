package com.example.plantstore.plantstore.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.plantstore.domain.CategoryModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant

@Composable
fun DetailName(
    item: PlantModel
) {
    val categories = remember { mutableStateListOf<CategoryModel>() }

    LaunchedEffect(Unit) {
        viewModel.loadCategory().observeForever {
            categories.clear()
            categories.addAll(it)
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 40.dp
            )
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.Title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        TextButton(
            onClick = { }
        ) {
            Text(
                text = "${categories.firstOrNull { it.Id == item.CategoryId }}",
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Preview
@Composable
fun DetailNamePreview() {
    DetailName(
        item = previewPlant,
    )
}