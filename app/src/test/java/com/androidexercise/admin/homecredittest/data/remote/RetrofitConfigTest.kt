package com.androidexercise.admin.homecredittest.data.remote

import org.junit.Test

import org.mockito.Mockito
import org.mockito.Mockito.doReturn

class RetrofitConfigTest {

    @Test
    fun getClient() {

        val apiRequest = Mockito.mock(APIService::class.java)
        val testRequest = apiRequest.getProduct()
        doReturn(testRequest).`when`(apiRequest).getProduct()
    }
}