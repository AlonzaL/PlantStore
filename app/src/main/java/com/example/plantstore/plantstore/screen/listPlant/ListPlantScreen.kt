package com.example.plantstore.plantstore.screen.listPlant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.navigation.PlantListType
import com.example.plantstore.plantstore.screen.common.CommonTopBar
import com.example.plantstore.plantstore.screen.common.PlantCard
import com.example.plantstore.plantstore.viewModel.MainViewModel

@Composable
fun ListPlantScreen(
    viewModel: MainViewModel,
    listType: PlantListType,
    onOpenDetail: (PlantModel) -> Unit,
    onBack: () -> Unit,
    onSetting: () -> Unit,
    onCart: () -> Unit
) {

    val plants by if (listType == PlantListType.POPULAR) {
        viewModel.listPopularPlant.collectAsState()
    } else {
        viewModel.listNewPlant.collectAsState()
    }

    val title = if (listType == PlantListType.POPULAR) "Popular Products" else "New Arrivals"

    Scaffold(
        containerColor = Color.White,
        topBar = {
            CommonTopBar(
                onBack = onBack,
                onCart = onCart,
                onSetting = onSetting
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding(),
                start = 30.dp,
                end = 30.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(span = { GridItemSpan(2) }) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp, top = 8.dp)
                )
            }

            items(
                items = plants
            ) { plant ->
                PlantCard(
                    item = plant,
                    onFavoriteClick = { viewModel.onFavoriteClick(plant)},
                    onClick = { onOpenDetail(plant) }
                )
            }

        }
    }
}

@Composable
fun ListPlantName(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = modifier
    )

}