package com.amirovdev.fragmentoverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Fragment - is a part of user interface that has its own lifecycle.
 * We can connect and disconnect it in one Activity, we can add them in xml files.
 * Fragments have own xml-files
 *
 * Fragments are meant to solve the problem of placing content on large screens(tablets)
 * Thanks to them we can open several fragments within one Activity and exchange the inf.
 * We can connect Fragment to Activity in xml code and also in class
 *
 * LifeCycle of Fragment is almost the same as Activity but it has more preparatory methods
 * at the beginning and at the end of the lifecycle. This is due to the fact that each
 * fragment is attached to the Activity
 *
 * How create: java -> New -> Fragment -> Fragment(Blank)
 * add Fragment to Activity: use <fragment> tag, set id
 *
 * Naming rules:
 * class name must end with 'Fragment' (LoginFragment)
 * xml file name must start with 'fragment_' (fragment_login.xml)
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}