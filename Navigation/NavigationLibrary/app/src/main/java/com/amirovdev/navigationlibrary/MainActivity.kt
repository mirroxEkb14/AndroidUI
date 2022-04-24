package com.amirovdev.navigationlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation

/**
   Navigation library simplifies the work with navigation. Dependencies:
   implementation 'androidx.navigation:navigation-fragment-ktx:2.4.2'
   implementation "androidx.navigation:navigation-ui-ktx:2.4.2"
 *
    Create a folder for out navigation graph: New -> Android Resource Directory -> Resource type: navigation
    Create a navigation.xml file, add the Fragments to the graph(it is needed to create these Fragments first)
 *
    We need to have our 'host-fragment' where it all will be happening. Create a <fragment> in activity_main
 *
    Create a controller that will control everything in MainActivity. This controller has two methods for
    navigation:
   'navigate(R.id.fragment)' that switches to the Fragment with its id
   'popBackStack()' that returns to the previous Fragment
 *
    Set the code in each Fragment, set listeners for next/previous buttons
 */

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }
}