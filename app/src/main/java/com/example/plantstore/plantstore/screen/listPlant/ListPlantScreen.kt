package com.example.plantstore.plantstore.screen.listPlant

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.plantstore.screen.detail.DetailHeader

@Composable
fun ListPlantScreen(
    title: String,
    onBack: () -> Unit,
    onSetting: () -> Unit,
    onCart: () -> Unit
) {
    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {
            item {
                DetailHeader(
                    onBack = onBack,
                    onSetting = onSetting,
                    onCart = onCart
                )
            }

            item {
                ListPlantName(
                    title = title
                )
            }

        }
    }
}

@Composable
fun ListPlantName(
    title: String
) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(start = 40.dp, top = 30.dp, bottom = 30.dp)
    )

}

@Composable
@Preview
fun ListPlantScreenPreview() {
    ListPlantScreen(
        onBack = {},
        onSetting = {},
        onCart = {},
        title = "Popular products"
    )
}