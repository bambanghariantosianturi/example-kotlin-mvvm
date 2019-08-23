package com.androidexercise.admin.homecredittest.data.remote

import com.androidexercise.admin.homecredittest.base.BaseAPIResponse
import com.androidexercise.admin.homecredittest.data.ProductDataSource
import com.androidexercise.admin.homecredittest.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource : ProductDataSource {

    private val apiService = RetrofitConfig.getClient()

    override fun getListProduct(callback: ProductDataSource.GetProductCallback) {
        val call = apiService.getProduct()
        call.enqueue(object : Callback<BaseAPIResponse<List<Product>>?> {
            override fun onFailure(call: Call<BaseAPIResponse<List<Product>>?>, t: Throwable) {
                callback.onDataNotAvailable(t.toString())
            }

            override fun onResponse(
                call: Call<BaseAPIResponse<List<Product>>?>,
                response: Response<BaseAPIResponse<List<Product>>?>
            ) {
                callback.onProductLoaded(response.body()?.data)
            }
        })
    }
}