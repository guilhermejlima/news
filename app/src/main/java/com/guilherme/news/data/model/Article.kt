package com.guilherme.news.data.model

import com.google.gson.annotations.SerializedName

class Article(
    @SerializedName("source")
    val source:SourceModel,
    @SerializedName("author")
    val author:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("image")
    val image:String,
    @SerializedName("publishedAt")
    val publishedAt:String)