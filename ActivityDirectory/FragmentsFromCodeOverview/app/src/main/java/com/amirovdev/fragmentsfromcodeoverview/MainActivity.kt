package com.amirovdev.fragmentsfromcodeoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

/**
 * Adding Fragment from code:
 * val tag = "fragment_1"
 * supportFragmentManager
 *   .beginTransaction()
 *
 *   .add(R.id.fragment_container, MyFragment1(), tag)
 *   -> add Fragment, first parameter - container id where we add our Fragment
 *   second parameter - class of our Fragment
 *   third parameter - tag by which we can find our Fragment (supportFragmentManager.findFragmentById(R.id.fragment))
 *
 *   .addToBackStack(null)
 *   -> when we laund Fragments 1, 2 and 3, then click on 'back' button they open in reverse order
 *
 *   .commit()
 *   -> apply everything
 *
 *   There is 'commitAllowingStateLoss()' that is used instead of 'commit()'. It is used in case if
 *   transaction will be performed after Activity state saving(screen flip), then an Exception is thrown
 */

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FrameLayout
    private lateinit var btnFragment1: Button
    private lateinit var btnFragment2: Button
    private lateinit var btnFragment3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnFragment1.setOnClickListener {
            val tag = "fragment_1"
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, MyFragment1(), tag)
                .addToBackStack(null)
                .commit()
        }

        btnFragment2.setOnClickListener {
            val tag = "fragment_2"
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, MyFragment2(), tag)
                .addToBackStack(null)
                .commit()
        }

        btnFragment3.setOnClickListener {
            val tag = "fragment_3"
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, MyFragment3(), tag)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun initView() {
        btnFragment1 = findViewById(R.id.add_fragment1)
        btnFragment2 = findViewById(R.id.add_fragment2)
        btnFragment3 = findViewById(R.id.add_fragment3)
        fragmentContainer = findViewById(R.id.fragment_container)
    }
}