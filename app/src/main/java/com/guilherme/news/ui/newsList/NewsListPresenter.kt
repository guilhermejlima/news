package com.guilherme.news.ui.newsList

import android.content.Context
import android.util.Log
import com.guilherme.news.data.API_KEY
import com.guilherme.news.data.TAG_ERROR
import com.guilherme.news.data.model.ResponseModel
import com.guilherme.news.data.remoteDataService.Repository
import com.guilherme.news.data.remoteDataService.newsApi
import com.guilherme.news.ui.MainArticleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsListPresenter(private val view: NewsListInterface.View) {

    fun onCreateCalled(repository: Repository, apiService: newsApi, context: Context){
        view.createLayoutManager()
        callNews(repository, apiService, context)
    }


    private fun callNews(repository: Repository,apiService: newsApi,context:Context){
        val call: Call<ResponseModel> = repository.callNews(apiService, API_KEY,"bbc-news")

        call.enqueue(object : Callback<ResponseModel> {
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.e(TAG_ERROR, t.toString())
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.isSuccessful){
                    val articleList = response.body()?.articles
                    if (articleList != null) {
                        if(articleList.isNotEmpty()) {
                            view.createAdapter(articleList,context)

                        }
                    }

                }
            }

        })
    }
}