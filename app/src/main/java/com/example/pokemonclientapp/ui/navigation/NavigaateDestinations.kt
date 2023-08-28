package com.example.pokemonclientapp.ui.navigation

interface NavigateDestinations {
    val route: String
}

object Search: NavigateDestinations {
    override val route = "search"
}

object Detail: NavigateDestinations {
    override val route = "detail"
}