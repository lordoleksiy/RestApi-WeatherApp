package com.example.restapi.api

import android.util.Log
import com.example.restapi.data.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.restapi.data.WeatherData.weatherResponse
import retrofit2.awaitResponse

class Repository {
    fun getForecast(){
        val call: Call<WeatherResponse?>? = RetrofitInstance.apiService.getForecast(RetrofitInstance.apiKEY, "Ukraine", 7)
        lateinit var response: WeatherResponse
        call!!.enqueue(object : Callback<WeatherResponse?> {
            override fun onResponse(call: Call<WeatherResponse?>?, response: Response<WeatherResponse?>) {
                val statusCode: Int = response.code()
                val resp: WeatherResponse? = response.body()
                if (resp != null) {
                    weatherResponse = resp
                }
                else Log.e("Error", "No data got!")
            }
            override fun onFailure(call: Call<WeatherResponse?>?, t: Throwable?) { Log.e("Error", "Error while catching data!") }
        })
    }

    suspend fun getForecast2(){
        val call: Call<WeatherResponse?>? = RetrofitInstance.apiService.getForecast(RetrofitInstance.apiKEY, "Ukraine", 7)
        val response = call?.awaitResponse()

        if (response?.isSuccessful == true) {
            Log.d("test", response.body().toString())
        }
        else{
            Log.e("test", "Error while catching request")
        }
    }
}