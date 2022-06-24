package com.example.assignment

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // on below line we are
    // creating variables for listview
    lateinit var City: ListView

    // creating array adapter for listview
    lateinit var listAdapter: ArrayAdapter<String>

    // creating array list for listview
    lateinit var cityList: ArrayList<String>

    // creating variable for searchview
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing variables of list view with their ids.
        City = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        // initializing list and adding data to list
        cityList = arrayListOf(
            "New York",
            "London",
            "Manchester",
            "Tokyo",
            "Berlin",
            "Barcelona",
            "Beijing",
            "Budapest",
            "Cartagena",
            "Rome",
            "Milan",
            "Turin",
            "Belfast",
            "Birmingham",
            "Cambridge",
            "Cardiff",
            "Coventry",
            "Durham",
            "Lancaster",
            "Leeds",
            "Leicester",
            "Lincoln",
            "Liverpool",
            "Nottingham"

        )


        // initializing list adapter and setting layout
        // for each list view item and adding array list to it.
        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            cityList
        )

        // on below line setting list
        // adapter to our list view.
        City.adapter = listAdapter

        // on below line we are adding on query
        // listener for our search view.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                if (cityList.contains(query)) {
                    // if query exist within list we
                    // are filtering our list adapter.
                    listAdapter.filter.filter(query)
                } else {
                    // if query is not present we are displaying
                    // a toast message as no data found..
                    Toast.makeText(this@MainActivity, "No city found..", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                listAdapter.filter.filter(newText)
                return false
            }
        })
    }

}
