package com.guilherme.news.ui

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guilherme.news.R
import com.guilherme.news.data.model.Article
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main_article_adapter.view.*


class MainArticleAdapter(private val articleArrayList: List<Article>, private var context: Context): RecyclerView.Adapter<MainArticleAdapter.ViewHolder>() {
    lateinit var onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.row_main_article_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val articleModel: Article = articleArrayList[position]
        if(!TextUtils.isEmpty(articleModel.title)) {
            holder.titleText.text = articleModel.title
        }

        if(!TextUtils.isEmpty(articleModel.description)) {
            holder.descriptionText.text = articleModel.description
        }

        holder.articlesAdapterParentLinear.tag = articleModel
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.article_adapter_tv_title
        val descriptionText: TextView = itemView.article_adapter_tv_description
        val articlesAdapterParentLinear: LinearLayout = itemView.article_adapter_ll_parent


    }

}