package com.example.freetogameclone.presentation.navigation

sealed class Screens(val route: String){

    object MainHomeScreen: Screens("main_home_screen")
    object DetailScreen: Screens("detail_screen")
    object GamesScreen: Screens("games_screen")
    object HomeScreen: Screens(route = "home_screen")
    object PCGamesScreen: Screens("pc_games_screen")
    object BrowserGamesScreen: Screens("browser_games_screen")
}
