package com.guilherme.news.data.remoteDataService

import com.guilherme.news.data.model.ResponseData
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface newsApi {
    @GET("https://newsapi.org/v2/top-headlines")
    fun getListofNews(@Query("sources")source:String ,@Query("apiKey")apiKey:String): Deferred<Response<ResponseData>>
}