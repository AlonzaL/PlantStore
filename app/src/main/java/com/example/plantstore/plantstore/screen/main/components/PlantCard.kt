package com.example.plantstore.plantstore.screen.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.plantstore.R
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant
import com.example.plantstore.ui.theme.Black
import com.example.plantstore.ui.theme.DarkGreen
import com.example.plantstore.ui.theme.Favorite
import com.example.plantstore.ui.theme.LightGreenBg
import com.example.plantstore.ui.theme.TextGray

@Composable
fun PlantCard(
    item: PlantModel,
    onClick: () -> Unit
) {
    Column (
        modifier = Modifier
            .width(160.dp) // Ширина карточки
            .clickable(onClick = onClick)
    ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(LightGreenBg)
            ) {
                Icon(
                    painter = painterResource(id = if (item.isFavorite) R.drawable.fav_filled else R.drawable.fav),
                    contentDescription = "Favorite",
                    tint = if (item.isFavorite) Favorite else TextGray, // Цвет как на макете (примерно)
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                        .size(24.dp)
                )

                AsyncImage(
                    model = item.imagePath.firstOrNull(),
                    contentDescription = item.title,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(140.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.title,
                color = Black,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "$ ${(item.price)}",
                fontWeight = FontWeight.Bold,
                color = DarkGreen,
                fontSize = 16.sp,
                maxLines = 2
            )
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