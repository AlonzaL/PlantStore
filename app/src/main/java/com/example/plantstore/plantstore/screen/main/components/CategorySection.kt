package com.example.plantstore.plantstore.screen.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun CategorySection(
    categories: List<String>
) {
    val rows = categories.chunked(3)
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        categories.forEach { category ->
            CategoryItem(
                category = category,
                onItemClick = { }
            )
        }
    }
}


@Composable
fun CategoryItem(
    category: String,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Text(
        text = category,
        fontSize = 14.sp,
        style = TextStyle(textDecoration = TextDecoration.Underline),
        modifier = modifier
            .clickable(
                onClick = onItemClick
            )
    )
}