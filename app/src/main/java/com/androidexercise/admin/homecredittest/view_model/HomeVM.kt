package com.androidexercise.admin.homecredittest.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidexercise.admin.homecredittest.base.BaseAPIResponse
import com.androidexercise.admin.homecredittest.model.Product
import com.androidexercise.admin.homecredittest.remote.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeVM : ViewModel() {

    private val list: MutableLiveData<List<Product>> = MutableLiveData()
    var status = MutableLiveData<Boolean?>()

    fun setItem() {
        val apiService = RetrofitConfig.getClient()
        val call = apiService.getProduct()
        call.enqueue(object : Callback<BaseAPIResponse<List<Product>>?> {
            override fun onFailure(call: Call<BaseAPIResponse<List<Product>>?>, t: Throwable) {
                status.value = false
            }

            override fun onResponse(
                call: Call<BaseAPIResponse<List<Product>>?>,
                response: Response<BaseAPIResponse<List<Product>>?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    list.postValue(response.body()?.data)
                    status.value = true
                } else {
                    status.value = false
                }
            }
        })
    }

    fun getItems(): MutableLiveData<List<Product>>? {
        return list
    }
}