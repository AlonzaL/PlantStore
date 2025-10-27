package com.example.plantstore.plantstore.Screen.Detail

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
import androidx.compose.ui.unit.dp
import com.example.plantstore.plantstore.Domain.PlantModel

@Composable
fun DetailScreen(
    item: PlantModel,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
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