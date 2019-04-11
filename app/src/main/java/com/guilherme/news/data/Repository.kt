package com.guilherme.news.data.remoteDataService

import com.guilherme.news.data.model.ResponseData
import kotlinx.coroutines.Deferred
import retrofit2.Response

class Repository(private val remoteDataService: RemoteDataService) {
    suspend fun callNews(newsApiClient: newsApi, token: String,source:String): Deferred<Response<ResponseData>> {
        return remoteDataService.callNews(newsApiClient, token, source)
    }

}