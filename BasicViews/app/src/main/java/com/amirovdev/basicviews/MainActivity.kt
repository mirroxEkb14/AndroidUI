package com.amirovdev.basicviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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

        val button = findViewById<Button>(R.id.toast_button)
//        button.setOnClickListener {
//            Toast.makeText(this, "Thin!", Toast.LENGTH_LONG).show()
//        }
    }

    // Context - objects of this class provide the access to base functions of the app
    // (resources, file system etc.), MainActivity inherits from this class, so that
    // through 'this' we get access to the Context
    fun onClickToast(view: View) {
        Toast.makeText(this, "Thin!", Toast.LENGTH_LONG).show()
    }
}