package com.androidexercise.admin.homecredittest.viewmodel

import com.androidexercise.admin.homecredittest.model.Product
import com.androidexercise.admin.homecredittest.data.remote.RetrofitConfig
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import retrofit2.Call
import retrofit2.Response

class HomeVMTest {

    private var callMock = mock<Call<Product>>()

    private inline fun <reified T : Any> mock(): T = mock(T::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getStatus() {
    }

    @Test
    fun setStatus() {
    }

    @Test
    fun setItem() {
        val productResponse = Product("", listOf(), "")
        val response = Response.success(productResponse)

        Mockito.`when`(callMock.execute()).thenReturn(response)

        //call
        val apiService = RetrofitConfig.getClient()
        apiService.getProduct()

    }

    @Test
    fun getItems() {
        //call
        val apiService = RetrofitConfig.getClient()
        apiService.getProduct().execute().isSuccessful
    }
}