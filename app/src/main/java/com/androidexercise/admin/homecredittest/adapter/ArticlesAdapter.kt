package com.androidexercise.admin.homecredittest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidexercise.admin.homecredittest.R
import com.androidexercise.admin.homecredittest.model.Product
import com.bumptech.glide.Glide

class ArticlesAdapter(private var list: List<Product.Items>) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

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
        private val imageArticle: ImageView = view.findViewById(R.id.iv_image_article)
        private val articlesName: TextView = view.findViewById(R.id.tv_article_title)

        fun onBind(items: Product.Items) {
            articlesName.text = items.article_title

            Glide.with(itemView)
                .load(items.article_image)
                .into(imageArticle)
        }
    }
}