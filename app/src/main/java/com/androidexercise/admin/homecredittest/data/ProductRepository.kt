package com.androidexercise.admin.homecredittest.data

import com.androidexercise.admin.homecredittest.data.remote.RemoteDataSource
import com.androidexercise.admin.homecredittest.model.Product

class ProductRepository : ProductDataSource{

    private val remoteDataSource = RemoteDataSource()

    override fun getListProduct(callback: ProductDataSource.GetProductCallback) {
        remoteDataSource.getListProduct(object : ProductDataSource.GetProductCallback {
            override fun onProductLoaded(product: List<Product>?) {
                callback.onProductLoaded(product)
            }

            override fun onDataNotAvailable(errorMessage: String) {
                callback.onDataNotAvailable(errorMessage)
            }
        })
    }
}