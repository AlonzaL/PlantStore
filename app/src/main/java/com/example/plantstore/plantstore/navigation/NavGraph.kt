package com.example.plantstore.plantstore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantstore.plantstore.Screen.Intro.WelcomeScreen
import com.example.plantstore.plantstore.Screen.Main.MainScreen
import com.example.plantstore.plantstore.ViewModel.MainViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
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
    }

}

sealed class Screen(
    val route: String
) {
    data object Intro:Screen("intro")
    data object Home: Screen("home")
    data object Detail: Screen("detail")
}