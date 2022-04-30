package com.amirovdev.hidebottomviewbehaviour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Scroll-Based ->
 * When scrolling down the View or ViewGroup hides and appears when scrolling up.
 * It starts collapsing when AppBarLayout is collapsed while scrolling down and
 * will appear only when scrolling up
 *
 *  Layout-Based ->
 *  BottomView is removed right after scrolling down and appeared right after
 *  scrolling up
 *
 *  main attribute ->
 *  app:layout_behavior="com.google.android.material.behavior.HideBottomViewOnScrollBehavior"
 *  also ->
 *  android:layout_gravity="bottom"
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}