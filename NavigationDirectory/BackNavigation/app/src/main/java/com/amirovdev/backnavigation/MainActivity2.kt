package com.amirovdev.backnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // when launching set BlankFragment1 to Activity2
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_activity2, BlankFragment1(), "BlankFragment1")
            .addToBackStack(null)
            .commit()

        // now the arrow in topAppBar can move you back when clicking
        setSupportActionBar(findViewById(R.id.topAppBar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    // When we go to Fragment1, then to Fragment2, then again to Fragment1
    // and then again to Fragment2, in stack we have 4 Fragments
    override fun onBackPressed() {
        /*
        With the following logic,
        when we go back from Fragment2(number 4 in stack, the last one),
        we get to Fragment1(number 3 in stack), then we go back again and get to
        Fragment2(number 2 in stack), then press a back button again -
        we get to Fragment1(number 1 in stack), then again back - Activity1
        */
        val fragments = supportFragmentManager.fragments
        if(fragments.last() is BlankFragment1 && fragments.size < 3) {
            finish()
        } else {
            super.onBackPressed()
        }

        /*
        With the following logic,
        when we go back from Fragment2(number 4 in stack, the last one),
        we get to Fragment1(number 3 in stack), then we go back again and get to Activity1
        (we leave two Fragments in stack and go immediately to Activity1)
        */
        when (supportFragmentManager.findFragmentById(R.id.container_activity2)) {
            is BlankFragment1 -> finish()
            else -> super.onBackPressed()
        }
    }
}