package com.guilherme.news.ui.newsList

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.guilherme.news.R
import com.guilherme.news.data.model.Article

import com.guilherme.news.data.remoteDataService.APIClient
import com.guilherme.news.data.remoteDataService.RemoteDataService
import com.guilherme.news.data.remoteDataService.Repository
import com.guilherme.news.data.remoteDataService.newsApi
import com.guilherme.news.ui.MainArticleAdapter
import kotlinx.android.synthetic.main.activity_main.*


class NewsListActivity : AppCompatActivity(), NewsListInterface.View {

    private lateinit var presenter:NewsListPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiClient = APIClient()
        val apiService:newsApi = apiClient.getClient().create(newsApi::class.java)
        val remoteDataService = RemoteDataService()
        val repository = Repository(remoteDataService)
        presenter = NewsListPresenter(this)

        presenter.onCreateCalled(repository,apiService,this)

    }

    override fun createAdapter(articleList:List<Article>, context:Context) {
        activity_main_rv.adapter = MainArticleAdapter(articleList, context)
    }

    override fun createLayoutManager() {
        val linearLayoutManager = LinearLayoutManager(this)
        activity_main_rv.layoutManager = linearLayoutManager
    }
}
