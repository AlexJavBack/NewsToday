package com.example.newstoday.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {
    @GET("news")
    suspend fun getNews(
        @Query("apikey")
        apikey: String,
        @Query("q")
        q: String,
    ): DataClassNews


}