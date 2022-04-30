package com.amirovdev.coordinatorlayoutoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * When scrolling, the top menu collapses, the background is changed,
 * the text size is changed, the button vanishes. The same happens
 * when we scroll in the other direction. CoordinatorLayout resolves
 * the problem of cooperation elements inside the container.
 *
 * Types of behavior ->
 * Scroll-based (the most common)
 * Layout-based (to move a single View on the screen when performing an action,
 * for example, we raise the button when a message pops up)
 *
 * (we can make it by Animations, but it will take us too much time
 * and it is difficult to connect all those animations together)
 *
 * Connect the library ->
 * implementation 'androidx.coordinatorlayout:coordinatorlayout:1.2.0'
 *
 *
 * to change the FAB btn icon color, use
 * app:tint=""
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}