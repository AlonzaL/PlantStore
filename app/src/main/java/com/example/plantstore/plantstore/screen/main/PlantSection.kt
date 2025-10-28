package com.example.plantstore.plantstore.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.plantstore.R
import com.example.plantstore.plantstore.domain.PlantModel

@Composable
fun PlantCard(
    item: PlantModel,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(
                width = 190.dp,
                height = 260.dp
            ),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
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
                    .size(165.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(
                        color = colorResource(R.color.bg_card)
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = item.ImagePath,
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
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "$ ${(item.Price)}",
                color = colorResource(R.color.price),
                fontSize = 16.sp,
                maxLines = 2
            )
        }
    }
}

@Composable
fun PlantSection(
    items: List<PlantModel>,
    onClick: (PlantModel) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .heightIn(min = 260.dp)
    ) {
        if (items.isEmpty()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        } else {
            LazyRow(
                contentPadding = PaddingValues(
                    horizontal = 16.dp
                )
            ) {
                items(items.take(3)) { item ->
                    PlantCard(
                        item = item,
                        onClick = { onClick(item) }
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun PlantCardPreview() {
    val item = PlantModel(
        Title = "Plant",
        Price = 25.3
    )
    PlantCard(item = item, onClick = {})
}