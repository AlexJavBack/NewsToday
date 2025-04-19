package com.example.newstoday.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newstoday.retrofit.GlobalNewsViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    val viewModel : GlobalNewsViewModel = viewModel()
    NavHost(navController = navController, startDestination = Routes.MainScreen.route) {
        composable(
            route = Routes.MainScreen.route) {
            ListItems(navController = navController, viewModel)
        }
        composable(
            route = Routes.detailScreen.route) {
            SelectCategoryNewsScreen(navController = navController)
        }
        composable(
            route = Routes.GlobalNewsScreen.route) {
            NewsScreen(navController = navController, viewModel)
        }
    }
}