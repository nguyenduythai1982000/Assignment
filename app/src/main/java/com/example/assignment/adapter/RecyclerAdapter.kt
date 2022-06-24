package com.example.assignment.adapter

import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.model.WeatherModel

class RecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var myData: List<WeatherModel> = ArrayList()
    fun setData(myData: LiveData<WeatherModel>){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO()
    }

    override fun getItemCount(): Int {
        return myData.size
    }


}