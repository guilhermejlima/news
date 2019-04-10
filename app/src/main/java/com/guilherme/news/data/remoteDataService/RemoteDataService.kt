package com.guilherme.news.data.remoteDataService

import com.guilherme.news.data.model.ResponseData
import retrofit2.Call

class RemoteDataService {

     fun callNews(newsApiClient: newsApi, token: String,source:String): Call<ResponseData> {
        return newsApiClient.getListofNews(source, token)
    }
}