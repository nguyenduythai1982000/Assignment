package com.example.assignment.api

class MainRepository constructor(private val retrofitService: WeatherAPI){
    fun getCityWeather() = retrofitService.getCityWeather("","bbf2282377b20d1781e8faf0457fb6fe")
}