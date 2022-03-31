package com.amirovdev.materialdesignthemesstyles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private var actionMode: ActionMode? = null

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

        // listener for Contextual action bar
        val textViewContextual = findViewById<TextView>(R.id.text_view_for_contextual_actionbar)
        textViewContextual.setOnLongClickListener {
            // if the actionMode is active and some actions are displayed
            if (actionMode != null) {
                return@setOnLongClickListener false
            }

            actionMode = startActionMode(object: ActionMode.Callback {
                // create the menu
                override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                    val inflater = p0?.menuInflater
                    inflater?.inflate(R.menu.contextual_actionbar, p1)
                    p0?.title = "Select option"
                    return true
                }

                override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                    return false
                }

                // process the clicks on the elements of the menu
                override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                    // find out what icon was clicked
                    when (p1?.itemId) {
                        R.id.photo -> Toast.makeText(this@MainActivity, "Photo", Toast.LENGTH_SHORT).show()
                        R.id.android -> Toast.makeText(this@MainActivity, "Android", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }

                // when we remove focus from the item
                override fun onDestroyActionMode(p0: ActionMode?) {
                    actionMode = null
                }

            })

            return@setOnLongClickListener true
        }
    }
}