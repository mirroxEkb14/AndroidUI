package com.amirovdev.materialcontextualactionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // ActionMode class instance
    private var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // the context menu appears when long clicking on the TextView
        text_view_greetings.setOnLongClickListener {
            // action mode is visible (created)
            if (actionMode != null) {
                return@setOnLongClickListener false
            }

            actionMode = startActionMode(object: ActionMode.Callback {
                // create the menu
                override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                    val inflater = p0?.menuInflater
                    inflater?.inflate(R.menu.out_menu, p1)
                    p0?.title = "Select options"
                    return true
                }

                override fun onPrepareActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                    return false
                }

                // process the pressings on the menu elements
                override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                    when (p1?.itemId) {
                        R.id.castle -> Toast.makeText(this@MainActivity, "Castle", Toast.LENGTH_SHORT).show()
                        R.id.agriculture -> Toast.makeText(this@MainActivity, "Agriculture", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }

                // when the item is not focused anymore
                override fun onDestroyActionMode(p0: ActionMode?) {
                    actionMode = null
                }

            })

            return@setOnLongClickListener true
        }
    }
}