package com.amirovdev.materialtopappbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // listener on 'menu' button
        val materialToolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        materialToolbar.setOnClickListener {
            Toast.makeText(this, "Hi from a Toolbar", Toast.LENGTH_SHORT).show()
        }

        // listener on menu buttons
        materialToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.favorite -> {
                    Toast.makeText(this, "It`s Favorite", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, "It`s Search", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "It`s More", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

    }
}