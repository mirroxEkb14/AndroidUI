package com.amirovdev.doubletabforexit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // the time passed from the first click to the second
    // (we will get the System time that comes as Long)
    private var backPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        // if we have fragments
//        if (supportFragmentManager.backStackEntryCount == 1)

        if (backPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            Toast.makeText(this, "Double tap for exit", Toast.LENGTH_SHORT).show()
        }

        backPressed = System.currentTimeMillis()
    }

    // The interval for which the user must tab the "Back" button again(2 secs)
    // The time interval in constant, so use companionObject
    companion object {
        const val TIME_INTERVAL = 2000
    }
}