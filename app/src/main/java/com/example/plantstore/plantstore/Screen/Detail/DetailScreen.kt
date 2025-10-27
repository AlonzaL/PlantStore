package com.example.plantstore.plantstore.Screen.Detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantstore.R
import com.example.plantstore.plantstore.Domain.PlantModel
import com.example.plantstore.plantstore.Helper.previewPlant

@Composable
fun DetailScreen(
    item: PlantModel,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(R.color.white)
            )
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            DetailHeader(
                onBack = onBack,
                onFavorite = {},
                onSetting = {}
            )
            DetailImage(
                imagePath = item.ImagePath[1]
            )
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(
                    topStart = 50.dp,
                    topEnd = 50.dp
                ),
                modifier = Modifier
                    .padding(
                        top = 400.dp
                    )
            ) {
//                DetailBody(
//                    item = item
//                )
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