package com.example.plantstore.plantstore.screen.common

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.plantstore.R

@Composable
fun CommonTopBar(
    onBack: () -> Unit,
    onCart: () -> Unit,
    onSetting: () -> Unit
) {
    BaseTopBar(
        onCartClick = onCart,
        onSettingsClick = onSetting,
        leftContent = {
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .size(48.dp)
                    // Смещаем кнопку влево, чтобы сама стрелка была ровно по краю 24dp,
                    // компенсируя прозрачное поле клика вокруг иконки.
                    .offset(x = (-12).dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }
        }
    )
}