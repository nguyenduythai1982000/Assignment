package com.example.assignment.api

import okhttp3.OkHttpClient
import okhttp3.Request

class APICity {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://countries-cities.p.rapidapi.com/location/country/US/city/list?page=2&per_page=20&population=1501")
        .get()
        .addHeader("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
        .addHeader("X-RapidAPI-Host", "countries-cities.p.rapidapi.com")
        .build()

    val response = client.newCall(request).execute()
}