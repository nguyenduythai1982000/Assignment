package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SearchView
import com.example.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<String>

    val cityList =
        listOf(
            "America",
            "India",
            "Nepal",
            "China",
            "Sri Lanka",
            "South Africa",
            "Bangladesh",
            "England",
            "Bhutan",
            "Finland",
            "Greenland"
        )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListView()
        setupSearchView()
    }
    private fun setupListView() {
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cityList)
        binding.listView.adapter = adapter

    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val isMatchFound = cityList.contains(p0)
                val msg = if (isMatchFound) "Found: $p0" else getString(R.string.no_match)
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }
        })
    }


}
