package com.amirovdev.statelistanimator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * StateListAnimator - use when, for example, we want to
 * animate the click and the moment when we free the button
 *
 * res -> animator -> Animator Resource File -> Root element: selector
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}