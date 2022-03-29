package com.amirovdev.basicviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.change_view_state_from_code.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // change the view state with findViewById
        val text = findViewById<TextView>(R.id.test_view)
//        text.text = "changed text from the code with findViewById"

        // kotlin synthetics
//        test_view.text = "changed text from the code with synthetics"
    }
}