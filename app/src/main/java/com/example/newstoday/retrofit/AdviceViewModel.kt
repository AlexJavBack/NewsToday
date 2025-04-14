package com.example.newstoday.retrofit

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newstoday.ItemColumModel
import kotlinx.coroutines.launch


class AdviceViewModel : ViewModel() {
    val imageUrl = mutableStateOf("Fetching advice...")
    val imageUrl = mutableStateOf("Fetching advice...")
    val imageUrl = mutableStateOf("Fetching advice...")

    init {
        fetchAdvice()
    }

    fun fetchAdvice() {
        viewModelScope.launch {
            try {
                var result : String = ""
                val response = RetrofitInstance.api.getNews("","ru")
                for(i in response.results) {
                    result = i.description
                    break
                }

                //And Remove the advice with _advice
                imageUrl.value = result
            } catch (e: Exception) {
                imageUrl.value = "Error: ${e.message}"
            }
        }
    }
}