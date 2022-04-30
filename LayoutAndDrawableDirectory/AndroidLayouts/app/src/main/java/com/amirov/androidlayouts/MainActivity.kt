package com.amirov.androidlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find the container
        val content = findViewById<ViewGroup>(R.id.content)
        for (i in 0..100) {
            // get the current view and add it to the container
            val view = layoutInflater.inflate(R.layout.scroll_view_item2, content, false)
            content.addView(view)
        }
    }
}