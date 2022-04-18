package com.amirovdev.applicationclassoverview

import android.app.Application
import android.content.res.Configuration

/**
 * After creating a class we need to write ' android:name=".App" ' in Manifest file
 */

class App : Application() {

    // the data that this class contains
    // but the objects in here might be destroyed anyway, so NPE can occur
    val objectInAppClass = "Object"

    // is called at the start of the application before other application components are created
    // here we can initialize global variables
    override fun onCreate() {
        super.onCreate()

        // initializing
        instance = this
    }

    // is called when the configuration is changed (screen flip)
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    // when the System has low Operation Memory
    override fun onLowMemory() {
        super.onLowMemory()
    }

    // to get the data from this class
    companion object {
        lateinit var instance: App
            private set
    }
}