package com.example.newstoday.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {
    @GET("news")
    suspend fun getNewsOlyApiKey(
        @Query("apikey")
        apikey: String
    ): DataClassNews

    @GET("news")
    suspend fun getNewsWithQuarry(
        @Query("apikey")
        apikey: String,
        @Query("q")
        q: String,
    ): DataClassNews

    @GET("news")
    suspend fun getNewsWithCountry(
        @Query("apikey")
        apikey: String,
        @Query("country")
        country: String,
    ): DataClassNews

    @GET("news")
    suspend fun getNewsWithCategory(
        @Query("apikey")
        apikey: String,
        @Query("category")
        category: String,
    ): DataClassNews

    @GET("news")
    suspend fun getNewsWithLanguage(
        @Query("apikey")
        apikey: String,
        @Query("language")
        language: String,
    ): DataClassNews

    @GET("news")
    suspend fun getNewsWithCountryAndCategory(
        @Query("apikey")
        apikey: String,
        @Query("country")
        country: String,
        @Query("category")
        category: String,
    ): DataClassNews

    @GET("news")
    suspend fun getNewsWithCountryAndLanguage(
        @Query("apikey")
        apikey: String,
        @Query("country")
        country: String,
        @Query("language")
        language: String,
    ): DataClassNews

    @GET("news")
    suspend fun getNewsWithLanguageAndCategory(
        @Query("apikey")
        apikey: String,
        @Query("language")
        language: String,
        @Query("category")
        category: String,
    ): DataClassNews

    @GET("news")
    suspend fun getNewsWithThreeParams(
        @Query("apikey")
        apikey: String,
        @Query("country")
        country: String,
        @Query("category")
        category: String,
        @Query("language")
        language: String,
    ): DataClassNews



}