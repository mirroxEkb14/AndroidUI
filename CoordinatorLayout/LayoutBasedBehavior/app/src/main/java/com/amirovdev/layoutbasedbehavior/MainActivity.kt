package com.amirovdev.layoutbasedbehavior

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * When clicking on FAB a SnackBar pops up and moves the button
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}