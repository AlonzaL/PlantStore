package com.example.plantstore.plantstore.screen.listPlant

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.navigation.navDetail
import com.example.plantstore.plantstore.screen.detail.DetailHeader
import com.example.plantstore.plantstore.screen.main.PlantCard
import com.example.plantstore.plantstore.viewModel.MainViewModel

@Composable
fun ListPlantScreen(
    viewModel: MainViewModel = viewModel(),
    title: String,
    onOpenDetail: (PlantModel) -> Unit,
    onBack: () -> Unit,
    onSetting: () -> Unit,
    onCart: () -> Unit
) {
    val popularPlant by viewModel.listPopularPlant.collectAsState()

    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .padding(30.dp)
        ) {
            item {
                DetailHeader(
                    onBack = onBack,
                    onSetting = onSetting,
                    onCart = onCart
                )
            }

            item {
                ListPlantName(
                    title = title
                )
            }

            item {
                ListPlant(
                    items = popularPlant,
                    onDetailClick = onOpenDetail
                )
            }

        }
    }
}

@Composable
fun ListPlantName(
    title: String
) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
//        modifier = Modifier
//            .padding(start = 40.dp, top = 30.dp, bottom = 30.dp)
    )

}