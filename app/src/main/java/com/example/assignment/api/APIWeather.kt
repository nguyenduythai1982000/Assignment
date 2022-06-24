package com.example.assignment.api

import okhttp3.OkHttpClient
import okhttp3.Request

class APIWeather {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://community-open-weather-map.p.rapidapi.com/weather?q=London%2Cuk&lat=0&lon=0&callback=test&id=2172797&lang=null&units=imperial&mode=xml")
        .get()
        .addHeader("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
        .addHeader("X-RapidAPI-Host", "community-open-weather-map.p.rapidapi.com")
        .build()

    val response = client.newCall(request).execute()
}