package com.example.plantstore.plantstore.screen.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.R
import com.example.plantstore.ui.theme.Black
import com.example.plantstore.ui.theme.SearchBg
import com.example.plantstore.ui.theme.TextGray

@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .height(52.dp), // Фиксированная высота для аккуратности
        placeholder = {
            Text(
                text = "indoor plants",
                fontSize = 14.sp,
                color = TextGray
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                tint = Black,
                modifier = Modifier.size(20.dp)
            )
        },
        shape = RoundedCornerShape(12.dp), // Мягкое скругление как на картинке
        colors = TextFieldDefaults.colors(
            focusedContainerColor = SearchBg,
            unfocusedContainerColor = SearchBg,
            disabledContainerColor = SearchBg,
            cursorColor = Black,
            focusedIndicatorColor = Color.Transparent, // Убираем подчеркивание
            unfocusedIndicatorColor = Color.Transparent,
        ),
        singleLine = true
    )
}