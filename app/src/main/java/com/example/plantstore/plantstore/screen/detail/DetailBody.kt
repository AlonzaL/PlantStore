package com.example.plantstore.plantstore.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.R
import com.example.plantstore.plantstore.domain.CategoryModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.helper.previewPlant

@Composable
fun DetailBody(
    item: PlantModel
) {

    Column(
        modifier = Modifier
            .padding(start = 40.dp, top = 25.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 28.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            StateColumn(
                title = "Type",
                value = item.Category
            )

            StateColumn(
                title = "Height",
                value = item.HeightFlower
            )

            StateColumn(
                title = "Pot Size",
                value = item.PotSize
            )

            StateColumn(
                title = "Pot Type",
                value = item.PotType
            )

        }

        Text(
            text = item.Description,
            color = colorResource(R.color.descr),
        )
    }

}

@Composable
@Preview
fun DetailBodyPreview() {
    DetailBody(
        item = previewPlant
    )
}

@Composable
fun RowScope.StateColumn(
    title: String,
    value: String
) {
    Column(
        modifier = Modifier
            .weight(1f)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = value,
            textAlign = TextAlign.Center
        )
    }
}