package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.adapter.RecyclerAdapter
import com.example.assignment.data.City
import com.example.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // view binding for the activity
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    // create reference to the adapter and the list
    // in the list pass the model of Language
    private lateinit var rvAdapter: RecyclerAdapter
    private lateinit var countryList: List<City>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // load data to language list
        loadLanguage()

        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        // pass it to rvLists layoutManager
        binding.recyclerView.layoutManager = layoutManager

        // initialize the adapter,
        // and pass the required argument
        rvAdapter = RecyclerAdapter(countryList.toMutableList())

        // attach adapter to the recycler view
        binding.recyclerView.adapter = rvAdapter
    }

    // add items to the list manually in our case
    private fun loadLanguage() {
        countryList = listOf(
            City("America"),
            City("London"),
            City("Brazil"),
            City("Germany"),
            City("Japan"),
            City("Korea"),
            City("Thailand"),
            City("Cambodia"),
            City("Italy"),
            City("Belgium"),
            City("France"),

        )
    }

    // on destroy of view make
    // the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
