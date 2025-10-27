package com.example.plantstore.plantstore.Screen.Detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.plantstore.R

@Composable
fun DetailHeader(
    onBack: () -> Unit,
    onFavorite: () -> Unit,
    onSetting: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .statusBarsPadding(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 8.dp
                )
        ) {
            Icon(
                painter = painterResource(R.drawable.back),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(25.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(
                        end = 16.dp,
                        top = 8.dp
                    )
            ) {
                Icon(
                    painter = painterResource(R.drawable.cart),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(25.dp)
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(
                        end = 16.dp,
                        top = 8.dp
                    )
            ) {
                Icon(
                    painter = painterResource(R.drawable.setting),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(25.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun DetailHeaderPreview() {
    DetailHeader(
        onBack = {},
        onFavorite = {},
        onSetting = {}
    )
}