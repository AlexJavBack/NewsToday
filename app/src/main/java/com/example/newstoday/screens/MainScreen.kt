@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.newstoday.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newstoday.retrofit.GlobalNewsViewModel

@Composable
fun ListItems(navController: NavController, screenVM: GlobalNewsViewModel) {
    Column {
        val searchText = remember {
            mutableStateOf("")
        }
        val isActive = remember {
            mutableStateOf(false)
        }
        SearchBar(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            query = searchText.value,
            onQueryChange = { text ->
                searchText.value = text
            },
            onSearch = {text ->
                screenVM.qu.value = text
                navController.navigate(Routes.GlobalNewsScreen.route)
            },
            placeholder = {
                Text(text = "Search")
            },
            active = isActive.value,
            onActiveChange = {
                isActive.value = it
            }
        ) {
            Text("")
        }
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Button(
                onClick = {
                    navController.navigate(Routes.detailScreen.route)
                },
                modifier = Modifier.padding(20.dp).size(60.dp)
            ) {
                Text("1")
            }
            Button(
                onClick = {
                },
                modifier = Modifier.padding(20.dp).size(60.dp)
            ) {
                Text("btCounter.value.toString(), fontSize = 14.sp")
            }
            Button(
                onClick = {
                },
                modifier = Modifier.padding(20.dp).size(60.dp)
            ) {
                Text("btCounter.value.toString(), fontSize = 14.sp")
            }
            Button(
                onClick = {
                },
                modifier = Modifier.padding(20.dp).size(60.dp)
            ) {
                Text("btCounter.value.toString(), fontSize = 14.sp")
            }
            Button(
                onClick = {
                },
                modifier = Modifier.padding(20.dp).size(60.dp)
            ) {
                Text("btCounter.value.toString(), fontSize = 14.sp")
            }
            Button(
                onClick = {
                },
                modifier = Modifier.padding(20.dp).size(60.dp)
            ) {
                Text("btCounter.value.toString(), fontSize = 14.sp")
            }
            Button(
                onClick = {
                },
                modifier = Modifier.padding(20.dp).size(60.dp)
            ) {
                Text("btCounter.value.toString(), fontSize = 14.sp")
            }
            Button(
                onClick = {
                },
                modifier = Modifier.padding(20.dp).size(60.dp)
            ) {
                Text("btCounter.value.toString(), fontSize = 14.sp")
            }
            Button(
                onClick = {
                },
                modifier = Modifier.padding(20.dp).size(60.dp)
            ) {
                Text("btCounter.value.toString(), fontSize = 14.sp")
            }
        }
    }

}
