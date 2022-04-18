package com.amirovdev.activitycallbacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

/**
 * Timber - a standard in development for logging
 * implementation "com.jakewharton.timber:timber:4.7.1"
 * We need to initialize Timber in the App class
 *
 * then we can go to Logcat(at the bottom of IDE and enter MainActivity)
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("OnCreate method")
    }

    override fun onStart() {
        super.onStart()

        Timber.d("onStart()")
    }

    override fun onResume() {
        super.onResume()

        Timber.d("onResume()")
    }

    override fun onPause() {
        super.onPause()

        Timber.d("onPause()")
    }

    override fun onStop() {
        super.onStop()

        Timber.d("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()

        Timber.d("onDestroy()")
    }
}