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
        val textView = TextView(ContextThemeWrapper(this, R.style.BackOrange))
        textView.text = "Hello world!"

        val container = findViewById<FrameLayout>(R.id.container)
        container.addView(textView)

        textView.setOnClickListener {
            container.removeAllViews()
            val textView2 = TextView(ContextThemeWrapper(this, R.style.BackRed))
            textView2.text = "Hello world"
            container.addView(textView2)
        }
    }
}