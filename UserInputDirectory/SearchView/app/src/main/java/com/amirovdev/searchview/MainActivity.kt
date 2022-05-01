package com.amirovdev.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat

/**
   When we have a list to look for, create a field for the input,
   to do this we create a menu 'search_menu.xml', then override
   the 'onCreateOptionsMenu' method

   import of SearchView
   -> import androidx.appcompat.widget.SearchView
 */

class MainActivity : AppCompatActivity() {

    // we`ll be looking for this list
    private val list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fullList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val mainTv = findViewById<TextView>(R.id.main_tv)

        menuInflater.inflate(R.menu.search_menu, menu)

        // find the item menu with searching
        val menuItem = menu.findItem(R.id.search)

        // connect it as a field for searching
        val searchView = menuItem.actionView as SearchView

        // set the change listener for text input
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            // when we click on the button
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (list.contains(query)) {
                    mainTv.text = "In list"
                    mainTv.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorGreen))
                } else {
                    mainTv.text = "Not in list"
                    mainTv.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorRed))
                }
                return false
            }

            // when text changes in real time
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun fullList() {
        for (i in 0 .. 9) {
            list.add("item$i")
        }
    }
}