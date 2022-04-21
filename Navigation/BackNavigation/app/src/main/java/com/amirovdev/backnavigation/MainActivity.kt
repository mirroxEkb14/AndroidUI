package com.amirovdev.backnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * To go back in the app we can in two ways:
 *      system bottom "back"
 *      a "back" arrow
 *
 * To create a "back" arrow in toolbar:
 *      in activity_main2.xml create AppBarLayout with MaterialToolbar
 *      in MainActivity.kt make three steps:
 *          1. set out Toolbar as 'support action bar' -> setSupportActionBar(findViewById(R.id.toolbar));
 *          2. tell the app that we want a "back" button -> supportActionBar?.setDisplayHomeAsUpEnabled(true);
 *          3. add Listener for the button -> toolbar.setNavigationOnClickListener { onBackPressed() }
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set Activity2
        btn_activity1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}