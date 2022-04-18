package com.amirovdev.lifecycleoverview

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * To implement a review of the component lifecycle
 *
 * LifecycleObserver is an interface that does not contain
 * any methods, all the logic is reached by annotations
 */

class LifeCycleListener : LifecycleObserver {

    // here we can create any methods, we just need to mark them with annotations,
    // what methods and when will be performed
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        // ...
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        // ...
    }

    // now when we launch the app, a message will be printed to the console
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(source: LifecycleOwner?, event: Lifecycle.Event?) {
        if (event?.targetState == Lifecycle.State.STARTED) {
            println("CURRENT STATE: STARTED")
        }
    }
}