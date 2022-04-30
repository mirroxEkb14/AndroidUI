package com.amirovdev.collapsingtoolbarlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlin.math.abs

/**
 * CollapsingToolbarLayout is a wrapper above the Toolbar. It is created to be
 * a child elements of AppBarLayout and take park in View cooperation
 * while animating collapsing/unfolding
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)

        val appbar = findViewById<AppBarLayout>(R.id.app_bar)
        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            // in unfolding condition
            if (verticalOffset == 0) {
                // set color to red
                toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
            }
            // in collapsing condition
            if (abs(verticalOffset) >= appBarLayout.scrollBarSize) {
                // set color to orange
                toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.orange))
            }
            toolbarLayout.title = verticalOffset.toString()
        })
    }
}