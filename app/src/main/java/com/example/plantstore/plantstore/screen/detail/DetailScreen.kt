package com.example.plantstore.plantstore.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant
import com.example.plantstore.plantstore.screen.common.CommonTopBar
import com.example.plantstore.plantstore.screen.detail.components.DetailBody
import com.example.plantstore.plantstore.screen.detail.components.DetailBottomBar
import com.example.plantstore.plantstore.screen.detail.components.DetailImage
import com.example.plantstore.plantstore.screen.detail.components.DetailTitle
import com.example.plantstore.ui.theme.TextGray

@Composable
fun DetailScreen(
    item: PlantModel,
    onBack: () -> Unit
) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            CommonTopBar(
                onBack = onBack,
                onCart = { },
                onSetting = { }
            )
        },
        bottomBar = {
            DetailBottomBar(
                price = item.price,
                onAddToCart = { }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            DetailTitle(
                title = item.title,
                category = item.category
            )
            Spacer(modifier = Modifier.height(24.dp))

            DetailImage(
                imagePath = item.imagePath[1] ?: ""
            )
            Spacer(modifier = Modifier.height(32.dp))

            DetailBody(
                item = item
            )
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = item.description,
                color = TextGray,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
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