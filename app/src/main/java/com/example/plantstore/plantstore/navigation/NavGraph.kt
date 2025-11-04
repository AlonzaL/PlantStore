package com.example.plantstore.plantstore.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.screen.auth.AuthLogInScreen
import com.example.plantstore.plantstore.screen.auth.AuthSingInScreen
import com.example.plantstore.plantstore.screen.detail.DetailScreen
import com.example.plantstore.plantstore.screen.intro.WelcomeScreen
import com.example.plantstore.plantstore.screen.listPlant.ListPlant
import com.example.plantstore.plantstore.screen.listPlant.ListPlantScreen
import com.example.plantstore.plantstore.screen.main.MainScreen
import com.example.plantstore.plantstore.screen.settings.SettingsScreen
import com.example.plantstore.plantstore.viewModel.AuthViewModel
import com.example.plantstore.plantstore.viewModel.MainViewModel

@Composable
fun NavGraph(
    mainViewModel: MainViewModel,
    authViewModel: AuthViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Intro.route
    ) {
        composable(Screen.Intro.route) {
            WelcomeScreen(
                onLogIn = {
                    navController.navigate(Screen.AuthLogIn.route) {
                        popUpTo(Screen.Intro.route) {
                            inclusive = true
                        }
                    }
                },
                onSignUp = {
                    navController.navigate(Screen.AuthSignUp.route) {
                        popUpTo(Screen.Intro.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.AuthLogIn.route) {
            AuthLogInScreen(
                onStartClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Intro.route) {
                            inclusive = true
                        }
                    }
                },
                onBack = {
                    navController.navigate(Screen.Intro.route)
                },
                viewModel = authViewModel
            )
        }

        composable(Screen.AuthSignUp.route) {
            AuthSingInScreen(
                onStartClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Intro.route) {
                            inclusive = true
                        }
                    }
                },
                onBack = {
                    navController.navigate(Screen.Intro.route)
                },
                viewModel = authViewModel
            )
        }

        composable(Screen.ListPlant.route) {
            ListPlantScreen(
                onBack = {
                    navController.navigate(Screen.Home.route)
                },
                onCart = {},
                onSetting = {},
                title = "Product"
            )
        }

        composable(Screen.Home.route) {
            MainScreen(
                viewModel = mainViewModel,
                onOpenDetail = {
                    plantModel ->
                    navController.navDetail(plantModel)
                },
                onCartClick = {},
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                },
                onSeeAllNew = {},
                onSeeAllPopular = {
                    navController.navigate(Screen.ListPlant.route)
                }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                viewModel = authViewModel
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
    data object AuthLogIn : Screen("authLogIn")
    data object AuthSignUp : Screen("authSingIn")
    data object Settings : Screen("settings")
    data object ListPlant : Screen("listPlant")
}