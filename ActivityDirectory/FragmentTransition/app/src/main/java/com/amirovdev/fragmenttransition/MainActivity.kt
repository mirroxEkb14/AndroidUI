package com.amirovdev.fragmenttransition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

/**
 * Layouts 'fragment_my1' and 'fragment_my2' must have:
 * - same image
 * - same android:transitionName="transition1"
 *
 * We cannot pass the inf between Fragments directly, must be broker
 * Max inf size - 500Kb
 * Fragments can have other Fragments (childFragmentManager)
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create first fragment
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, MyFragment1())
            .addToBackStack(null)
            .commit()
    }

    // open the second Fragment
    fun startSecondFragment(imageButton: ImageView) {
        supportFragmentManager
            .beginTransaction()
            .addSharedElement(imageButton, "transition1")
            .addToBackStack(null)
            .replace(R.id.container, MyFragment2())
            .commit()
    }
}