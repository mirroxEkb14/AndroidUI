package com.amirovdev.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * To place an element on the bottom of CoordinatorLayout,
 * use android:layout_gravity="bottom"
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_map -> Toast.makeText(this, "Map", Toast.LENGTH_SHORT).show()
                R.id.action_dial -> Toast.makeText(this, "Dial", Toast.LENGTH_SHORT).show()
                R.id.action_email -> Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show()
            }
            false
        }
    }
}