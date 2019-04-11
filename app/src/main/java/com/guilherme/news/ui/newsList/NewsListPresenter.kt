package com.guilherme.news.ui.newsList

import android.content.Context
import android.util.Log
import com.guilherme.news.data.API_KEY
import com.guilherme.news.data.TAG_ERROR
import com.guilherme.news.data.model.ResponseData
import com.guilherme.news.data.remoteDataService.Repository
import com.guilherme.news.data.remoteDataService.newsApi
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class NewsListPresenter(private val view: NewsListInterface.View): CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    fun onCreateCalled(repository: Repository, apiService: newsApi, context: Context){
        view.changeTheNameOfActionBarTitle("BBC")
        view.createLayoutManager()
        callNews(repository, apiService, context)
    }


    private fun callNews(repository: Repository,apiService: newsApi,context:Context){

        launch {
            runBlocking {
                val call= repository.callNews(apiService, API_KEY,"bbc-news").await()


                withContext(Dispatchers.Default){
                    try {
                        if(call.isSuccessful){
                            val articleList = call.body()?.articles
                            if (articleList != null) {
                                if (articleList.isNotEmpty()) {
                                    view.createAdapter(articleList,context)

                                } else {
                                    Log.e("ERROR","List is empty")
                                }

                            } else {
                                Log.e("ERROR","List is null")

                            }
                        }else{
                        }
                    }catch (e: Exception){
                        Log.e("ERROR",e.toString())
                    }

                }
            }
        }
    }
}