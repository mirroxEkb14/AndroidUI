package com.amirovdev.backnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
 *
 * When navigating in the opposite direction:
 *      if the Activity has Fragments in stack, in the beginning navigation goes in Fragments,
 *      only then in the previous Activity
 *
 * When switching to another Activity, the Activity is not destroyed
 * (destroys only with finish() method)
 *
 * When navigating in the opposite direction, Activities are destroyed
 *
 * What will happen to Activity if it is transparent when switching between Activities?
 * - Activity will be in onPause(), we can see the first Activity, but there is no cooperation with it
 * to make Activity transparent: create style with two tags:
 *      "android:windowIsTranslucent" = true // if the previous Activity will be in onStop() or onPause()
 *      "android:windowBackground" = @android:color/transparent
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