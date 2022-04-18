package com.amirovdev.applicationclassoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Application - the main class of Android app, that contains all the components,
 * all the activities, services, providers and broadcasts
 *
 * In most cases this class is used to initialize global state before the first
 * activity is displayed. Cases that we might need to write own Application implementation:
 * - do some logic before the first activity is displayed
 * - global variables that might be needed from other Activities
 * - constants storage (it is better to use Object)
 *
 * To write own Application implementation, create an App class
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // from any application point we can get a variable from App class
        val getObjectFromAppClass = App.instance.objectInAppClass
    }
}