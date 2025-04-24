package com.example.newstoday.screens

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newstoday.CardNew
import com.example.newstoday.R
import com.example.newstoday.retrofit.GlobalNewsViewModel

@Composable
fun NewsScreen(navController: NavController, screenVM: GlobalNewsViewModel){
    screenVM.fetchNews()
    val newsList = screenVM.arrayNews

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight().
            paint(
                painterResource(id = R.drawable.second_phone),
                contentScale = ContentScale.FillBounds)
    ) {
        itemsIndexed(newsList) {
            index, item ->
            CardNew(item = item, screenVM, index)
        }
    }
    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center) {
        Button(modifier = Modifier.padding(bottom = 50.dp)
            .sizeIn(minHeight = 60.dp)
            , colors = ButtonDefaults.buttonColors(contentColor = Color.Black,
                containerColor = Color.Yellow) ,
            onClick = {
            screenVM.arrayNews.clear()
            screenVM.language.value = ""
            screenVM.qu.value = ""
            screenVM.country.value = ""
            screenVM.category.value = ""
            screenVM.isRead.value = false
            navController.navigate(Routes.MainScreen.route)
        }  ) {
            Text("Back", fontSize = 24.sp)
        }
    }
}
