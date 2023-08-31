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
            composable(Search.route) {
                SearchScreen(
                    onClick = { url ->
                        navController.navigate("${Detail.route}/$url")
                    }
                )
            }
            composable(
                route = "${Detail.route}/{url}",
                arguments = listOf(
                    navArgument("url"){ type = NavType.StringType }
                )
            ) {backStackEntry ->
                val url = backStackEntry.arguments?.getString("url") ?: ""
                DetailScreen(url)
            }
        }
    )
}