package com.example.restapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    const val apiKEY =  "f20834bc34dc4ef2b03110213221606"
    private const val url = "https://api.weatherapi.com/v1/"
    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}