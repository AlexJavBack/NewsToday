package com.example.newstoday.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newstoday.retrofit.GlobalNewsViewModel

@Composable
fun screen(navController: NavController){
    val viewModel: GlobalNewsViewModel = viewModel()
    val newsList = viewModel.arrayNews

    Column(
        modifier = Modifier
            .fillMaxHeight(),
    ) {
            Text(
                text = (newsList.getOrNull(0)?.description ?: ""),
                        textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
            Text(text = (newsList.getOrNull(1)?.content ?: ""))
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { viewModel.fetchNews() }) {
                Text("Refresh Advice")
            }
            Text("advices")
    }
}

//        itemsIndexed(listOf(ItemColumModel(22, advice))) {
//            index, item ->
//
