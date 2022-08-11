package com.example.assignment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherAPIService {
    private var retrofit: Retrofit? = null
    var BASE_URL = "https://api.openweathermap.org"

    fun getApiInterface(): WeatherAPI?{
        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(WeatherAPI::class.java)
    }
}