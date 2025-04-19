package com.example.newstoday.retrofit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newstoday.ItemColumModel
import kotlinx.coroutines.launch
import okhttp3.internal.wait


class GlobalNewsViewModel : ViewModel() {

    //val str = mutableStateOf(false)// value for testing
    val qu = mutableStateOf("")


    //val _advice = MutableLiveData<ArrayList<ItemColumModel>>() value for testing
    val arrayNews  = mutableStateListOf<ItemColumModel>()

    fun fetchNews(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getNews("",
                    qu.value
                )
                val responseSize = response.results.size // need to execute duplicates
                for(i in response.results) {
                    if(arrayNews.size >= responseSize) {
                        break
                    }
                    arrayNews += ItemColumModel(i.image_url,i.title,i.description, i.link)
                }

            } catch (e: Exception) {
                //imageUrl.value = "Error: ${e.message}"
            }
        }

    }
}