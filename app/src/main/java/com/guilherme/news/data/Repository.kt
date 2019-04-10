package com.guilherme.news.data.remoteDataService

import com.guilherme.news.data.model.ResponseModel
import retrofit2.Call

class Repository(val remoteDataService: RemoteDataService) {
    fun callNews(newsApiClient: newsApi, token: String,source:String): Call<ResponseModel> {
        return remoteDataService.callNews(newsApiClient, token, source)
    }

}