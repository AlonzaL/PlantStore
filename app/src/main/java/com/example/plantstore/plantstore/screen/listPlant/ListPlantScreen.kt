package com.example.plantstore.plantstore.screen.listPlant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.navigation.PlantListType
import com.example.plantstore.plantstore.screen.main.components.PlantCard
import com.example.plantstore.plantstore.viewModel.MainViewModel
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ListPlantScreen(
    viewModel: MainViewModel = viewModel(),
    listType: PlantListType,
    onOpenDetail: (PlantModel) -> Unit,
    onBack: () -> Unit,
    onSetting: () -> Unit,
    onCart: () -> Unit
) {
    val plantsState: StateFlow<List<PlantModel>>
    val title: String

    when (listType) {
        PlantListType.POPULAR -> {
            plantsState = viewModel.listPopularPlant
            title = "Популярные растения"
        }
        PlantListType.NEW -> {
            plantsState = viewModel.listNewPlant
            title = "Новинки"
        }
    }

    val plants by plantsState.collectAsState()

    Scaffold(
        containerColor = Color.White
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
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {

            }

            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                ListPlantName(
                    title = title,
                    modifier = Modifier.padding(vertical = 14.dp)
                )
            }

            items(
                items = plants
            ) { plant ->
                PlantCard(
                    item = plant,
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

@Composable
@Preview
fun ListPlantScreenPreview() {
    ListPlantScreen(
        onOpenDetail = { },
        onBack = {},
        onSetting = {},
        onCart = {},
        viewModel = TODO(),
        listType = TODO()
    )
}