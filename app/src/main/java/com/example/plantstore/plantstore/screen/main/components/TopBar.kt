package com.example.plantstore.plantstore.screen.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.R
import com.example.plantstore.ui.theme.Black
import com.example.plantstore.ui.theme.TextGray

@Composable
fun TopBar(
    userName: String,
    onCartClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Welcome,",
                fontSize = 14.sp,
                color = TextGray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = userName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onCartClick) {
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp),
                    tint = Black
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = onSettingsClick) {
                Icon(
                    painter = painterResource(id = R.drawable.setting),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp),
                    tint = Black
                )
            }
        }
    }
}

@Composable
@Preview
fun TopBarPreview() {
    TopBar(
        userName = "Имя",
        onCartClick = {},
        onSettingsClick = {}
    )
}