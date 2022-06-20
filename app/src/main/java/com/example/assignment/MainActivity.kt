package com.example.assignment

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.model.City
import kotlin.collections.contains


class MainActivity : AppCompatActivity() {
    // view binding for the activity
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryList = arrayOf(
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
//        val rvAdapter: ArrayAdapter<City> =
//            ArrayAdapter(this, android.R.layout.simple_list_item_1, countryList)
//        binding.recyclerView.adapter = rvAdapter
//
//
//        binding.searchView.setOnQueryTextListener(
//            object : SearchView.OnQueryTextListener {
//                override fun onQueryTextSubmit(query: String?): Boolean {
//                    binding.searchView.clearFocus()
//                    if (countryList.contains(query)) {
//                        rvAdapter.filter.filter(query)
//                    }
//                    else{
//
//                    }
//                    return false
//                }
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//                    TODO("Not yet implemented")
//                }
//
//            })
    }

    // on destroy of view make
    // the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
//        binding = null
    }


}


