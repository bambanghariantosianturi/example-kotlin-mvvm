package com.androidexercise.admin.homecredittest.remote

import com.androidexercise.admin.homecredittest.base.BaseAPIResponse
import com.androidexercise.admin.homecredittest.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    /**
     * GET -> https://private-a8e48-hcidtest.apiary-mock.com/home
     */
    @GET("home")
    fun getProduct () : Call <BaseAPIResponse<List<Product>>>
}