package com.example.restapi

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.restapi.api.RetrofitInstance
import com.example.restapi.data.WeatherResponse
import com.example.restapi.functions.Timer
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var weather: WeatherResponse
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var currentTime: String = ""
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val timer = Timer()
        GlobalScope.launch(Dispatchers.IO) {
            launch {  timer.changeTime() }
            launch {  while (true){
                currentTime = timer.getTime()
                setTime()
                delay(500L)
            } }
        }
        getForecast()

    }
    private fun setTime(){
        runOnUiThread {
            findViewById<TextView>(R.id.time).text = currentTime
        }
    }

    private fun getForecast(){
        val call: Call<WeatherResponse?>? = RetrofitInstance.apiService.getForecast(RetrofitInstance.apiKEY, "Ukraine", 7)
        lateinit var response: WeatherResponse
        call!!.enqueue(object : Callback<WeatherResponse?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<WeatherResponse?>?, response: Response<WeatherResponse?>) {
                val statusCode: Int = response.code()
                val resp: WeatherResponse? = response.body()
                if (resp != null) {
                    weather = resp
                    findViewById<TextView>(R.id.temp).text = weather.current.temp_c.toString() + "°C"
                }
                else Log.e("Error", "No data got!")
            }
            override fun onFailure(call: Call<WeatherResponse?>?, t: Throwable?) { Log.e("Error", "Error while catching data!") }
        })
    }
}