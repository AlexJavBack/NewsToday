package com.example.newstoday.retrofit

data class DataClassNews(
    val status: String,
    val totalResults: Int,
    val results: List<DataClassNewsDetails>
)

data class DataClassNewsDetails(
    val article_id : String,
    val title : String,
    val link : String,
    val keywords : List<String>,
    val creator : List<String>,
    var description : String,
    val content : String,
    val pubDate : String,
    val pubDateTZ : String,
    val image_url : String,
    val video_url : String,
    val source_id : String,
    val source_name : String,
    val source_priority : Int,
    val source_url : String,
    val source_icon : String,
    val language : String,
    val country : List<String>,
    val category : List<String>,
    val sentiment : String,
    //val sentiment_stats : SentimentStats,
    //val ai_tag : List<String>,
    //val ai_region : List<String>,
    //val ai_org : List<String>,
    val duplicate : Boolean,
)

data class SentimentStats(
    val positive : String,
    val neutral : String,
    val negative : String,
)