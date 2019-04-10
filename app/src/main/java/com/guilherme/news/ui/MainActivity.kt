package com.guilherme.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.guilherme.news.R
import com.guilherme.news.data.model.ResponseModel
import com.guilherme.news.data.remoteDataService.APIClient
import com.guilherme.news.data.remoteDataService.newsApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val API_KEY:String = "08fdfc01f1e24ed2a4176a01dabab0dd"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val apiClient = APIClient()
        val apiService:newsApi = apiClient.getClient().create(newsApi::class.java)

        val call:Call<ResponseModel> = apiService.getListofNews("bbc-news",API_KEY)

        val linearLayoutManager = LinearLayoutManager(this)
        activity_main_rv.layoutManager = linearLayoutManager

        call.enqueue(object : Callback<ResponseModel> {
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.e("erro", t.toString())
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.isSuccessful){
                    val articleList = response.body()?.articles
                    if (articleList != null) {
                        if(articleList.isNotEmpty()) {
                            val mainArticleAdapter = MainArticleAdapter(articleList, this@MainActivity)
                            activity_main_rv.adapter = mainArticleAdapter
                        }
                    }

                }
            }

        })


    }
}
