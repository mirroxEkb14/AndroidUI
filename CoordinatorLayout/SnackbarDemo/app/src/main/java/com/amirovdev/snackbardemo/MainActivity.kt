package com.amirovdev.snackbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Layout-based behavior
 * When clicking on FAB a SnackBar pops up and moves the button
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        val snackBar = Snackbar.make(main_layout, "Snackbar!", Snackbar.LENGTH_SHORT)
        snackBar.setAction("Action") {
            Toast.makeText(this, "Toast!", Toast.LENGTH_SHORT).show()
        }
        snackBar.setActionTextColor(ContextCompat.getColor(this, R.color.design_default_color_error))

        fab.setOnClickListener {
            snackBar.show()
        }
    }
}