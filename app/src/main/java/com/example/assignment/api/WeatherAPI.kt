package com.example.assignment.api


import com.example.assignment.model.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "bbf2282377b20d1781e8faf0457fb6fe"

//https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
//https://api.openweathermap.org/data/2.5/weather?q=London&appid={API key}
interface WeatherAPI {
    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("lat") latitude: String,
        @Query("lon") longtitude: String,
        @Query("appid") API_KEY: String
    ):retrofit2.Call<WeatherModel>

    @GET("data/2.5/weather")
    fun getCityWeather(
        @Query("q") country: String,
        @Query("appid") API_KEY: String
    ):Call<WeatherModel>



}