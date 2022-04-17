package com.amirovdev.statusbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Change statusbar color ->
 * res -> values -> themes -> themes.xml -> <item name="android:statusBarColor" tools:targetApi="l">@color/black</item>
 *
 * Change transparency ->
 * <item name="android:windowTranslucentStatus">true</item>
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}