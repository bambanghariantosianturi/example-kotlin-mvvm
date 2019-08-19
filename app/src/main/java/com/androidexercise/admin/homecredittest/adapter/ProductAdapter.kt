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

class ProductAdapter(private var list: List<Product.Items>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.productName.text = list[position].product_name

        Glide.with(holder.itemView)
            .load(list[position].product_image)
            .into(holder.imageGrid)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageGrid: ImageView = view.findViewById(R.id.iv_image_grid)
        val productName: TextView = view.findViewById(R.id.tv_grid_title)
    }
}