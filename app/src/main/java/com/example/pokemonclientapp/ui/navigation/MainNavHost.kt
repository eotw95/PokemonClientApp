package com.example.pokemonclientapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                        onClick = {
                            navController.navigate(Detail.route)
                        }
                    )
                }
            )
            composable(
                route = Detail.route,
                content = {
                    DetailScreen()
                }
            )
        }
    )
}