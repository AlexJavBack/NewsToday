package com.example.newstoday.retrofit

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newstoday.ItemColumModel
import kotlinx.coroutines.launch


class GlobalNewsViewModel : ViewModel() {

    //val imageUrl = mutableStateOf("") value for testing


    //val _advice = MutableLiveData<ArrayList<ItemColumModel>>() value for testing
    var arrayNews  = mutableStateListOf<ItemColumModel>()


    init {
        fetchNews()
    }

    fun fetchNews(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getNews("","ru")
                for(i in response.results) {
                    var s = 0
                    arrayNews += ItemColumModel(i.image_url,i.title,i.description)
                    s++
                    if (s < 2) {
                        break
                    }
                }

            } catch (e: Exception) {
                //imageUrl.value = "Error: ${e.message}"
            }
        }

    }
}