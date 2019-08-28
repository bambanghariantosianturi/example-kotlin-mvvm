package com.androidexercise.admin.homecredittest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidexercise.admin.homecredittest.R
import com.androidexercise.admin.homecredittest.model.Product
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_grid.view.*

class ProductAdapter(private var list: List<Product.Items>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
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
        private val imageGrid = view.iv_image_grid
        private val productName = view.tv_grid_title

        fun onBind(items: Product.Items) {
            productName.text = items.product_name

            Glide.with(itemView)
                .load(items.product_image)
                .into(imageGrid)
        }

    }
}