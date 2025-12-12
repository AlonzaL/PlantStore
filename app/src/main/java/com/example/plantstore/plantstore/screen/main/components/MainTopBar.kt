package com.example.plantstore.plantstore.screen.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
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
import com.example.plantstore.plantstore.screen.common.BaseTopBar
import com.example.plantstore.ui.theme.Black
import com.example.plantstore.ui.theme.TextGray

@Composable
fun MainTopBar(
    userName: String,
    onCartClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    BaseTopBar(
        onCartClick = onCartClick,
        onSettingsClick = onSettingsClick,
        leftContent = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Welcome,",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    lineHeight = 14.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = userName,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    )
}

@Composable
@Preview
fun TopBarPreview() {
    MainTopBar(
        userName = "Имя",
        onCartClick = {},
        onSettingsClick = {}
    )
}