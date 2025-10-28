package com.example.plantstore.plantstore.screen.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.plantstore.domain.CategoryModel

@Composable
fun CategorySection(
    categories: SnapshotStateList<CategoryModel>,
    showCategoryLoading: Boolean
) {
    if (showCategoryLoading) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        val rows = categories.chunked(3)
        val context = LocalContext.current

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            categories.forEach { category ->
                CategoryItem(
                    category = category,
                    modifier = Modifier
                        .weight(1f),
                    onItemClick = {
//                        val intent = Intent(context, ItemsListActivity::class.java).apply {
//                            putExtra("id", category.Id.toString())
//                            putExtra("title", category.Name.toString())
//                        }

//                        startActivity(context, intent, null)
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryItem(
    category: CategoryModel,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Text(
        text = category.Name,
        fontSize = 14.sp,
        style = TextStyle(textDecoration = TextDecoration.Underline),
        modifier = modifier
            .clickable(
                onClick = onItemClick
            )
    )
}