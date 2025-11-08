package com.example.plantstore.plantstore.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.plantstore.R
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant

@Composable
fun PlantCard(
    item: PlantModel,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            //.padding(8.dp)
            .size(
                width = 138.dp,
                height = 250.dp
            ),
        shape = RoundedCornerShape(10.dp),
        //elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 138.dp, height = 168.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(
                        color = colorResource(R.color.bg_card)
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = painterResource(R.drawable.flower_1)
                        //item.ImagePath[0]
                    ,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Fit
                )

            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.Title,
                color = colorResource(R.color.black),
                fontSize = 16.sp,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(9.dp))

            Text(
                text = "$ ${(item.Price)}",
                color = colorResource(R.color.price),
                fontSize = 16.sp,
                maxLines = 2
            )
        }
    }
}

@Preview
@Composable
fun PlantCardPreview() {
    PlantCard(
        item = previewPlant,
        onClick = {}
    )
}