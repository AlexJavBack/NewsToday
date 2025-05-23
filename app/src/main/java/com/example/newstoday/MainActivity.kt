package com.example.newstoday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.newstoday.retrofit.GlobalNewsViewModel
import com.example.newstoday.screens.NavigationGraph
import com.example.newstoday.ui.theme.NewsTodayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navControllerMainActivity = rememberNavController()
            val screensDataViewModel = remember {
                GlobalNewsViewModel()
            }
            NavigationGraph(navController = navControllerMainActivity)
        }
    }
}

