package com.example.newstoday.retrofit

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newstoday.ItemColumModel
import com.example.newstoday.until.Constants
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import okhttp3.internal.wait


class GlobalNewsViewModel : ViewModel() {

    //val str = mutableStateOf(false)// value for testing
    val qu = mutableStateOf("")
    val mainScreenGlobalNewsTextButton = mutableStateOf("")
    val detailsScreenGlobalNewsTextButton = mutableStateOf("")
    val country = mutableStateOf("")
    val category = mutableStateOf("")
    val language = mutableStateOf("")
    val isRead = mutableStateOf(false)


    //val _advice = MutableLiveData<ArrayList<ItemColumModel>>() value for testing
    val arrayNews  = mutableStateListOf<ItemColumModel>()


    fun fetchNews(){
        fun isValueNull(text : String): String{
            if (text.isNullOrEmpty()) {
                val result = ""
                return result
            }
            else return text
        }
        fun addDataFromResponse(list : DataClassNews) {

            for(i in list.results) {
                if(arrayNews.size >= list.results.size) {
                    break
                }
                else {
                    arrayNews += ItemColumModel(isValueNull(i.image_url),isValueNull(i.title),isValueNull(i.description), isValueNull(i.link))
                }
            }
        }
        viewModelScope.launch {

            try {
                if(qu.value == "" && country.value == "" && category.value == "" && language.value == "") {
                    val response = RetrofitInstance.api.getNewsOlyApiKey(Constants.API_KEY
                    )
                    addDataFromResponse(response)
                }
                if(qu.value != "") {
                    val response = RetrofitInstance.api.getNewsWithQuarry(Constants.API_KEY,
                        qu.value
                    )
                    addDataFromResponse(response)
                    isRead.value = true
                }
                if(qu.value == "" && country.value != "" && category.value == "" && language.value == "") {
                    val response = RetrofitInstance.api.getNewsWithCountry(Constants.API_KEY,
                        country.value
                    )
                    addDataFromResponse(response)
                }
                if(qu.value == "" && country.value == "" && category.value != "" && language.value == "") {
                    val response = RetrofitInstance.api.getNewsWithCategory(Constants.API_KEY,
                        category.value
                    )
                    addDataFromResponse(response)
                }
                if(qu.value == "" && country.value == "" && category.value == "" && language.value != "") {
                    val response = RetrofitInstance.api.getNewsWithLanguage(Constants.API_KEY,
                        language.value
                    )
                    addDataFromResponse(response)
                }
                if(qu.value == "" && country.value != "" && category.value != "" && language.value == "") {
                    val response = RetrofitInstance.api.getNewsWithCountryAndCategory(Constants.API_KEY,
                        country.value, category.value
                    )
                    addDataFromResponse(response)
                }
                if(qu.value == "" && country.value != "" && category.value == "" && language.value != "") {
                    val response = RetrofitInstance.api.getNewsWithCountryAndLanguage(Constants.API_KEY,
                        country.value, language.value
                    )
                    addDataFromResponse(response)
                }
                if(qu.value == "" && country.value == "" && category.value != "" && language.value != "") {
                    val response = RetrofitInstance.api.getNewsWithLanguageAndCategory(Constants.API_KEY,
                        language.value, category.value
                    )
                    addDataFromResponse(response)
                }
                if(qu.value == "" && country.value != "" && category.value != "" && language.value != "") {
                    val response = RetrofitInstance.api.getNewsWithThreeParams(Constants.API_KEY,
                        country.value,language.value,category.value
                    )
                    addDataFromResponse(response)
                }

            } catch (e: Exception) {
                Log.d("catch exception", e.message.toString())
            }
        }


    }
}