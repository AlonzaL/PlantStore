package com.example.plantstore.plantstore.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.plantstore.R
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant

@Composable
fun DetailImage(
    imagePath: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colorResource(R.color.white)
            )
            .padding(
                start = 40.dp,
                end = 40.dp
            )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
        ) {
            Card(
                modifier = Modifier
                    .width(350.dp)
                    .height(430.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        shape = RoundedCornerShape(10.dp),
                        color = colorResource(R.color.bg_card)
                    ),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = colorResource(R.color.bg_card),
            ) {
            }
            AsyncImage(
                model = imagePath,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(270.dp)
                    .offset(y = (50).dp)
                    .graphicsLayer(
                        // А потом визуально увеличивается в 3 раза
                        scaleX = 2f,
                        scaleY = 2f
                    )
            )
//            Image(
//                painter = painterResource(R.drawable.flower_2),
//                contentDescription = null,
//                contentScale = ContentScale.Fit,
//                modifier = Modifier
//                    .size(270.dp)
//                    .offset(y = (50).dp)
//                    .graphicsLayer(
//                        // А потом визуально увеличивается в 3 раза
//                        scaleX = 2f,
//                        scaleY = 2f
//                    )
//            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(
                        color = Color.Gray
                    )
            )
            repeat(3) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color.LightGray
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