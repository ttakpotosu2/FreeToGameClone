package com.example.freetogameclone.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.freetogameclone.presentation.sceens.BrowserGamesScreen
import com.example.freetogameclone.presentation.sceens.DetailScreen
import com.example.freetogameclone.presentation.sceens.GamesScreen
import com.example.freetogameclone.presentation.sceens.HomeScreen
import com.example.freetogameclone.presentation.sceens.MainHomeScreen
import com.example.freetogameclone.presentation.sceens.PCGamesScreen

@Composable
fun NavigationGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.HomeScreen.route){
            HomeScreen(navHostController)
        }
        composable(route = Screens.MainHomeScreen.route){
            MainHomeScreen(navHostController)
        }
        composable(route = Screens.DetailScreen.route + "/{gameId}"){
            DetailScreen()
        }
        composable(route = Screens.BrowserGamesScreen.route){
            BrowserGamesScreen(navHostController = navHostController)
        }
        composable(route = Screens.PCGamesScreen.route){
            PCGamesScreen(navHostController = navHostController)
        }
        composable(route = Screens.GamesScreen.route){
            GamesScreen(navHostController = navHostController)
        }
    }
}