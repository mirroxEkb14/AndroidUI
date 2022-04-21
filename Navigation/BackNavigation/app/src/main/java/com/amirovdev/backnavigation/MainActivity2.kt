package com.amirovdev.backnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // when launching set BlankFragment1 to Activity2
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_activity2, BlankFragment1())
            .addToBackStack(null)
            .commit()

        setSupportActionBar(findViewById(R.id.topAppBar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}