package com.androidexercise.admin.homecredittest.data

import com.androidexercise.admin.homecredittest.model.Product

interface ProductDataSource {

    fun getListProduct(callback: GetProductCallback)

    interface GetProductCallback {

        fun onProductLoaded(product: List<Product>?)

        fun onDataNotAvailable(errorMessage: String)

    }

}