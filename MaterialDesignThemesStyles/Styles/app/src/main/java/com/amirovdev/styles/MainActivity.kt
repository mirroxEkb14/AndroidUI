package com.amirovdev.styles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.FrameLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // if we want to change the style dynamically(in the code),
        // the View must be created in the code
        // (because the style is set in the constructor of View, so if the View is already
        // created, the style is set too)
        val textView = TextView(ContextThemeWrapper(this, R.style.BackOrange)) // textView create
        textView.text = "Hello world!" // the text is set

        val container = findViewById<FrameLayout>(R.id.container) // find container for View
        container.addView(textView) // add View to container

        // change the style dynamically
        textView.setOnClickListener {
            container.removeAllViews() // remove all views
            val textView2 = TextView(ContextThemeWrapper(this, R.style.BackRed)) // create a new View with a new background
            textView2.text = "Hello world" // add text to View
            container.addView(textView2) // add to container
        }
    }
}