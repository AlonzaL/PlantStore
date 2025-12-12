package com.example.plantstore.plantstore.navigation

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.screen.auth.AuthLogInScreen
import com.example.plantstore.plantstore.screen.auth.AuthSingInScreen
import com.example.plantstore.plantstore.screen.detail.DetailScreen
import com.example.plantstore.plantstore.screen.intro.WelcomeScreen
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

        composable(
            route = Screen.ListPlant.route,
            arguments = listOf(navArgument("listType") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val listTypeString = backStackEntry.arguments?.getString("listType")

            val listType = try {
                PlantListType.valueOf(listTypeString ?: PlantListType.POPULAR.name)
            } catch (e: IllegalArgumentException) {
                PlantListType.POPULAR
            }

            ListPlantScreen(
                listType = listType,
                onOpenDetail = { plantModel ->
                    navController.navDetail(plantModel)
                },
                onBack = { navController.popBackStack() },
                onSetting = { },
                onCart = { },
                viewModel = mainViewModel
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
                    navController.navigate(Screen.Setting.route)
                },
                onSeeAllNew = {
                    Log.d("NAVIGATION", "Click received inside NavGraph! New") // Проверка
                    navController.navigate(Screen.ListPlant.createRoute(PlantListType.NEW))
                },
                onSeeAllPopular = {
                    Log.d("NAVIGATION", "Click received inside NavGraph!") // Проверка
                    navController.navigate(Screen.ListPlant.createRoute(PlantListType.POPULAR))
                }
            )
        }

        composable(Screen.Setting.route) {
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
                    viewModel = mainViewModel,
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
    data object Setting : Screen("setting")
    data object ListPlant : Screen("list_screen/{listType}") {
        fun createRoute(listType: PlantListType): String {
            return "list_screen/${listType.name}"
        }
    }
}

enum class PlantListType {
    POPULAR,
    NEW
}