package com.example.plantstore.plantstore.screen.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.R
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant
import com.example.plantstore.ui.theme.Black
import com.example.plantstore.ui.theme.DarkGray

@Composable
fun DetailBody(
    item: PlantModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StateColumn(
            title = "Type",
            value = item.category
        )

        StateColumn(
            title = "Height",
            value = item.heightFlower
        )

        StateColumn(
            title = "Pot Size",
            value = item.potSize
        )

        StateColumn(
            title = "Pot Type",
            value = item.potType
        )

    }
}

@Composable
fun StateColumn(
    title: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = DarkGray
        )
    }
}