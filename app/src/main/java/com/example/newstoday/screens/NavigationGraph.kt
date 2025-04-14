package com.example.newstoday.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.MainScreen.route) {
        composable(
            route = Routes.MainScreen.route) {
            ListItems(navController = navController)
        }
        composable(
            route = Routes.detailScreen.route) {
            Scroll(navController = navController)
        }
        composable(
            route = Routes.GlobalNewsScreen.route) {
            screen(navController = navController)
        }
    }
}