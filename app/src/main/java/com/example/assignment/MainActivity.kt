package com.example.assignment

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.contains
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.model.Weather
import com.example.assignment.model.WeatherModel

class MainActivity : AppCompatActivity() {
    // on below line we are
    // creating variables for listview

    // creating array adapter for listview
    //lateinit var listAdapter: ArrayAdapter<String>

    // creating array list for listview
    lateinit var cityList: MutableLiveData<WeatherModel>

    // creating variable for searchview
    lateinit var searchView: androidx.appcompat.widget.SearchView

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initializing variables of list view with their ids.
        searchView = findViewById(R.id.idSearchView)

//        // initializing list and adding data to list
//        cityList = ArrayList()
//        cityList.add("London")
//        cityList.add("Manchester")
//        cityList.add("Tokyo")
//        cityList.add("Berlin")
//        cityList.add("Barcelona")
//        cityList.add("Beijing")
//        cityList.add("Budapest")
//        cityList.add("Cartagena")
//        cityList.add("Rome")
//        cityList.add("Milan")
//        cityList.add("Belfast")
//        cityList.add("Birmingham")
//        cityList.add("Cambridge")
//        cityList.add("Cardiff")
//        cityList.add("Coventry")


        // initializing list adapter and setting layout
        // for each list view item and adding array list to it.
//        listAdapter = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_1,
//            cityList
//        )
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomListAdapter(this, cityList)
        LinearLayoutManager(this).also { recyclerView.LayoutManager = it }
        recyclerView.adapter = adapter
        // on below line setting list
        // adapter to our list view.
        //city.adapter = listAdapter
        // on below line we are adding on query
        // listener for our search view.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                if (recyclerView.contains(query)) {
                    // if query exist within list we
                    // are filtering our list adapter.

                    listAdapter.filter.filter(query)

                } else {
                    // if query is not present we are displaying
                    // a toast message as no data found..
                    Toast.makeText(this@MainActivity, "No city found..", LENGTH_LONG)
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
        recyclerView.onItemClickListener = AdapterView.OnItemClickListener() { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position)
            Toast.makeText(this, "Selected: ${selectedItem}", LENGTH_LONG).show()


        }
    }

}


