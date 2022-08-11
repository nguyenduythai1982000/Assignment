package com.example.assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment.api.MainRepository
import com.example.assignment.model.Sys
import com.example.assignment.model.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(val repository: MainRepository): ViewModel() {
    val cityList = MutableLiveData<List<WeatherModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCity(){
        val response = repository.getCityWeather()
        response.enqueue(object : Callback<WeatherModel?> {
            override fun onResponse(call: Call<WeatherModel?>, response: Response<WeatherModel?>) {
                cityList.postValue(response.body())
            }

            override fun onFailure(call: Call<WeatherModel?>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}

private fun <T> MutableLiveData<T>.postValue(body: WeatherModel?) {
    TODO("Not yet implemented")
}
