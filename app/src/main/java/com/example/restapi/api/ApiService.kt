package com.example.restapi.api

import com.example.restapi.data.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast.json")
    fun getForecast(@Query("key") key: String, @Query("q") location: String, @Query("days") days: Int): Call<WeatherResponse?>?
}