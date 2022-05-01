package com.amirovdev.searchviewsuggestion

import android.database.Cursor
import android.database.MatrixCursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.cursoradapter.widget.CursorAdapter
import androidx.cursoradapter.widget.SimpleCursorAdapter

class MainActivity : AppCompatActivity() {

    // our improvised bd
    private val suggestionList = arrayListOf(
        "item1", "item2", "item3", "item4",
        "item5", "item6", "item7", "item8"
    )

    // implements the offers when searching
    private lateinit var mAdapter: SimpleCursorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val from = arrayOf("item") // bd columns
        val to = intArrayOf(android.R.id.text1) // fields display

        /*
         initialize the adapter
         this -> context from what we create this adapter (@requireActivity if Fragment)
         R.layout.item -> the markup of the offer itself
         CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER -> the logic these offers to appear
         */
        mAdapter = SimpleCursorAdapter(this,
            R.layout.item,
            null,
            from,
            to,
            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val menuItem = menu.findItem(R.id.search)
        val searchView = menuItem.actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                populateAdapter(newText)
                return false
            }
        })
        // add the Adapter
        searchView.suggestionsAdapter = mAdapter

        // set the listener
        searchView.setOnSuggestionListener(object: SearchView.OnSuggestionListener {

            // when we select some of the offers
            override fun onSuggestionSelect(position: Int): Boolean {
                return true
            }

            // when we click on the offer
            override fun onSuggestionClick(position: Int): Boolean {
                // find the item by 'position'
                val cursor: Cursor = mAdapter!!.getItem(position) as Cursor
                // from the bd of 'items' column we get the string
                val txt: String = cursor.getString(cursor.getColumnIndex("items".))
                // set the text to the searchView
                // true - when we click on the offer and the request is done immediately
                // false - the text will be added and no request
                searchView.setQuery(txt, false)
                searchView.clearFocus()
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    // takes the text from input field, compare it with what we have in bd
    // and populate Adapter
    private fun populateAdapter(query: String) {
        // in our bd
        val c = MatrixCursor(arrayOf(BaseColumns._ID, "items")) // cursor

        // verify if we have any of the items starts with the request that comes from search field(query)
        // and then we add it to the bd
        // gives some result if 2 or more letters are entered
        for (i in suggestionList.indices) {
            if (suggestionList[i].toLowerCase().contains(query.toLowerCase())) c.addRow(arrayOf(i, suggestionList[i]))
        }
    }
}