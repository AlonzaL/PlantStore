package com.example.plantstore.plantstore.screen.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.plantstore.R
import com.example.plantstore.ui.theme.ActivePoint
import com.example.plantstore.ui.theme.LightGreenBg
import com.example.plantstore.ui.theme.NotActivePoint

@Composable
fun DetailImage(
    imagePath: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(horizontal = 24.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(LightGreenBg)
            )
            AsyncImage(
                model = imagePath,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(270.dp)
                    .offset(y = (-20).dp)
                    .graphicsLayer(
                        // А потом визуально увеличивается в 3 раза
                        scaleX = 2f,
                        scaleY = 2f
                    )
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(
                        color = ActivePoint
                    )
            )
            repeat(3) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(
                            color = NotActivePoint
                        )
                )
            }
        }

    }
}


@Composable
@Preview
fun DetailImagePreview() {
    DetailImage(
        imagePath = "previewPlant"
    )
}