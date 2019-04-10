package com.guilherme.news.ui.newsList

import android.content.Context
import com.guilherme.news.data.model.Article

interface NewsListInterface {
    interface View{

        fun createAdapter(articleList:List<Article>, context: Context)

        fun createLayoutManager()

        fun changeTheNameOfActionBarTitle(title:String)
    }

}