package com.example.newstoday.screens

sealed class Routes(val route: String) {
    object MainScreen: Routes(route = "MainScreen")
    object GlobalNewsScreen: Routes(route = "GlobalNewsScreen")
}