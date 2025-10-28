package com.example.plantstore.plantstore.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.screen.detail.DetailScreen
import com.example.plantstore.plantstore.screen.intro.WelcomeScreen
import com.example.plantstore.plantstore.screen.main.MainScreen
import com.example.plantstore.plantstore.viewModel.MainViewModel

@Composable
fun NavGraph(
    viewModel: MainViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Intro.route
    ) {
        composable(Screen.Intro.route) {
            WelcomeScreen(
                onStartClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Intro.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            MainScreen(
                viewModel = viewModel,
                onOpenDetail = {
//                    plantModel ->
//                    navController.navDetail(plantModel)
                }
            )
        }

        composable(Screen.Detail.route) {
            val prevEntry = remember(navController) {
                navController.previousBackStackEntry
            }
            val plant = remember(prevEntry) {
                prevEntry?.savedStateHandle?.get<PlantModel>("plant")
            }

            LaunchedEffect(prevEntry, plant) {
                if (plant == null) {
                    navController.popBackStack()
                } else {
                    prevEntry?.savedStateHandle?.remove<PlantModel>("plant")
                }
            }
            if (plant != null) {
                DetailScreen(
                    item = plant,
                    onBack = { navController.popBackStack() }
                )
            } else {
                Spacer(modifier = Modifier.height(1.dp))
            }
        }
    }

}

sealed class Screen(
    val route: String
) {
    data object Intro : Screen("intro")
    data object Home : Screen("home")
    data object Detail : Screen("detail")
}