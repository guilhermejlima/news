package com.guilherme.news.data.model

import com.google.gson.annotations.SerializedName

class ResponseData(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0
)