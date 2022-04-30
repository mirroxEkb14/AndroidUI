package com.amirovdev.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * For creating a custom view:
 *      create xml-file with markup
 *      create a class for xml-file
 *      insert the custom view into the markup
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}