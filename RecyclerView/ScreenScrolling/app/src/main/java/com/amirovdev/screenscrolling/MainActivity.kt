package com.amirovdev.screenscrolling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.screenscrolling.adapter.MyAdapter

/**
 * We can replace ViewPager with PageSnapHelper
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val pageSnapHelper = PagerSnapHelper()
        pageSnapHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter = MyAdapter()
    }
}