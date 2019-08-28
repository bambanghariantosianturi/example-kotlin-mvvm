package com.androidexercise.admin.homecredittest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidexercise.admin.homecredittest.R
import com.androidexercise.admin.homecredittest.model.Product
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article.view.*

class ArticlesAdapter(private var list: List<Product.Items>) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = list[position]
        holder.onBind(items)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageArticle = view.iv_image_article
        private val articlesName = view.tv_article_title

        fun onBind(items: Product.Items) {
            articlesName.text = items.article_title

            Glide.with(itemView)
                .load(items.article_image)
                .into(imageArticle)
        }
    }
}