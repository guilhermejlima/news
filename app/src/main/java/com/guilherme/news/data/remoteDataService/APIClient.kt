package com.guilherme.news.data.remoteDataService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    val BASE_URL:String = "https://newsapi.org/v2/"

    fun getClient(): Retrofit {
        val retrofit =  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }
}