package com.amirovdev.recyclerviewoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.recyclerviewoverview.adapter.MyAdapter
import com.amirovdev.recyclerviewoverview.model.Game

/**
 * Prescribe a dependence ->
 * implementation 'androidx.recyclerview:recyclerview:1.1.0'
 *
 * What is needed to connect the RecyclerView ->
 *      Model(films)
 *      The performance of the item (item.xml)
 *      Adapter(MyAdapter), connect it to the RecyclerView
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the list of games
        fun getItems(): ArrayList<Game> {
            return arrayListOf(
                Game(0, R.drawable.half_life2, "Half life 2", getString(R.string.half_life_desc)),
                Game(1, R.drawable.portal2, "Portal 2", getString(R.string.portal2_desc)),
                Game(2, R.drawable.the_witcher, "The Witcher", getString(R.string.the_wither_desc)),
                Game(3, R.drawable.stalker_shadow_of_chernobyl, "S.T.A.L.K.E.R.: Shadow of Chernobyl", getString(R.string.stalker_shadow_of_chernobyl_desc)),
                Game(4, R.drawable.metro_2033, "Metro 2033", getString(R.string.metro_2033_desc))
            )
        }

        // find RecyclerView, set the Adapter and connect it to the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = MyAdapter(getItems())
        recyclerView.adapter = adapter
    }
}