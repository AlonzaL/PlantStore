package com.example.plantstore.plantstore.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plantstore.R

@Composable
fun DetailHeader(
    onBack: () -> Unit,
    onCart: () -> Unit,
    onSetting: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .padding(0.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.back),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(22.dp)
            )
        }

        Row(
        ) {
            IconButton(
                onClick = onCart
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
                onClick = onSetting
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
        onCart = {},
        onSetting = {}
    )
}