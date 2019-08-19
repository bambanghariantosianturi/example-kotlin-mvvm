package com.androidexercise.admin.homecredittest.remote

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import retrofit2.await
import retrofit2.awaitResponse

class RetrofitConfigTest {

    @Test
    fun getClient() {

        val apiRequest = Mockito.mock(APIService::class.java)
        val testRequest = apiRequest.getProduct()
        doReturn(testRequest).`when`(apiRequest).getProduct()
    }
}