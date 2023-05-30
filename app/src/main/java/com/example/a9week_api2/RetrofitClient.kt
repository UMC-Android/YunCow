package com.example.a9week_api2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private var instance: RetrofitClient? = null
    private var retrofitInterface: RetrofitInterface? = null
    private val baseUrl = "http://apis.data.go.kr"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInterface = retrofit.create(RetrofitInterface::class.java)
    }

    fun getInstance(): RetrofitClient {
        if (instance == null) {
            instance = RetrofitClient
        }
        return instance!!
    }

    fun getRetrofitInterface(): RetrofitInterface {
        return retrofitInterface!!
    }
}