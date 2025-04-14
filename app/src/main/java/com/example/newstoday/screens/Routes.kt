package com.example.newstoday.screens

sealed class Routes(val route: String) {
    object MainScreen: Routes(route = "MainScreen")
    object detailScreen: Routes(route = "DetailScreen")
    object GlobalNewsScreen: Routes(route = "GlobalNewsScreen")
}