package com.example.restapi.functions

import android.annotation.SuppressLint
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

class Timer{
    private var currentTime: IntArray? = null;
    fun getTime(): String{
        return if (currentTime != null) "${currentTime!![0]}h:${currentTime!![1]}m:${currentTime!![2]}s"
        else ""
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    suspend fun changeTime(){
        if (currentTime == null)
            currentTime = SimpleDateFormat("hh:mm:ss").format(Date()).toString().split(":").map { it.toInt() }.toIntArray()
        currentTime?.let {
            while (true){
                delay(1000L)
                it[2] += 1
                if (it[2] >= 60){
                    it[2] = 0
                    it[1] += 1
                }
                if (it[1] >= 60){
                    it[1] = 0
                    it[0] += 1
                }
                if (it[0] >= 24){
                    it[0] = 0
                    it[2] += 1
                }
            }
        }
    }
}
