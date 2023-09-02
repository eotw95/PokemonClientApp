package com.example.pokemonclientapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pokemonclientapp.ui.detail.DetailScreen
import com.example.pokemonclientapp.ui.screen.search.SearchScreen

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "search",
        builder = {
            composable(
                route= Search.route,
                content = {
                    SearchScreen(
                        onClick = { id ->
                            navController.navigate("${Detail.route}/$id")
                        }
                    )
                }
            )
            composable(
                route = "${Detail.route}/{id}",
                arguments = listOf(
                    navArgument(name = "id") { type = NavType.IntType }
                ),
                content = { backStackEntry ->
                    val id = backStackEntry.arguments?.getInt("id") ?: 0
                    DetailScreen(
                        id = id,
                        onClickButton = {
                            navController.navigateUp()
                        }
                    )
                }
            )
        }
    )
}