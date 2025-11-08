package com.example.plantstore.plantstore.screen.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.R
import com.example.plantstore.plantstore.domain.PlantModel

@Composable
fun SectionHeader(
    title: String,
    onSeeAll: (() -> Unit)?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
        )
        if (onSeeAll != null) {
            TextButton(
                onClick = onSeeAll
            ) {
                Text(
                    text = "view all",
                    color = colorResource(R.color.black),
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    modifier = Modifier
                        .offset(x = 12.dp)
                )
            }
        } else {
            Text(
                text = "view all",
                color = colorResource(R.color.black),
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
        }
    }
}