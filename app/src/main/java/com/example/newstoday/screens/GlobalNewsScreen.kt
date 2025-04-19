package com.example.newstoday.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.newstoday.CardNew
import com.example.newstoday.retrofit.GlobalNewsViewModel

@Composable
fun NewsScreen(navController: NavController, scrren: GlobalNewsViewModel){
    scrren.fetchNews()
    val newsList = scrren.arrayNews

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(),
    ) {
        itemsIndexed(newsList) {
            index, item ->
            CardNew(item = item, scrren, index)
        }
    }
}
