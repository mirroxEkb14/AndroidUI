package com.amirovdev.lifecycleoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * LifeCycle - a class that contains the information about life cycle of
 * some component and allows other objects to watch it
 *
 * LifeCycle has an Enum class Event that contains all the application states:
 * Lifecycle.Event.ON_CREATE
 * Lifecycle.Event.ON_START
 * Lifecycle.Event.ON_RESUME
 * Lifecycle.Event.ON_PAUSE
 * Lifecycle.Event.ON_STOP
 * Lifecycle.Event.ON_DESTROY
 * Lifecycle.Event.ON_ANY
 *
 * but also it contains States. The difference is: Events - just an event that some
 * component moved from one state to another, but State - the states themselves
 *
 * When we are out of memory, the application starts deleting everything that is not
 * currently used to give more memory to the foreground application
 * (deleting everything that played in background). So that there are two callbacks:
 * - onLowMemory is called when the application is already destroyed
 * - onTrimMemory(level: Int) is called with various criticality levels, 'level' variable
 * tells how much the System wants to free memory
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // now we watch this Activity
        val lifeCycleListener = LifeCycleListener()
        lifecycle.addObserver(lifeCycleListener)
    }
}