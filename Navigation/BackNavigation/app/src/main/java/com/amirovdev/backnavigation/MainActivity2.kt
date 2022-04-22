package com.amirovdev.backnavigation

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

    override fun onBackPressed() {
//        if (supportFragmentManager.findFragmentById(R.id.container_activity2)!! == getVisibleFragment()) {
//            finish()
//        }

//        val fragments = supportFragmentManager.fragments
//        if(fragments.last() is BlankFragment1 && fragments.size < 3) {
//            finish()
//        }

        val fragments = supportFragmentManager.fragments
        if (fragments[fragments.size - 1] is BlankFragment1) finish()

        super.onBackPressed()
    }

    private fun getVisibleFragment(): Fragment? {
        return supportFragmentManager.fragments
            .filter { it.isVisible }
            .getOrNull(0)
    }
}