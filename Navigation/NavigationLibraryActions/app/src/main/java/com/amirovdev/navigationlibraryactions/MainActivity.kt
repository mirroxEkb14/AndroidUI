package com.amirovdev.navigationlibraryactions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation

/**
 * see OneFragment.kt for a classical way to pass data
 *
 * Pass the data with the help of navigation graph:
 * go to navigation.xml, select the Fragment where the data come, on the right 'Arguments',
 * click '+', Name: name for an argument, Type: the type of the variable
 * If we pass the data from a navigation graph and from the Fragment, we get both of them,
 * but the keys must be different
 */

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}