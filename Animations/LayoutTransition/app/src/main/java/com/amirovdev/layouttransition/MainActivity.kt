package com.amirovdev.layouttransition

/**
 * LayoutTransition - automatic animations of changes in a container
 * when adding/removing elements
 *
 * in layout -> ' android:animateLayoutChanges="true" ' attribute
 *
 * We cannot change a sub-element in the View
 * (btnContainer.layoutTransition.enableTransitionType(LayoutTransition.CHANGING))
 */

import android.animation.AnimatorInflater
import android.animation.LayoutTransition
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private lateinit var btnContainer: LinearLayout
    private lateinit var btnAdd: Button
    private lateinit var btnRemove: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        // set new features (to add own animations to sub-elements)
        btnContainer.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        // create 'animator' folder: res -> animator
        btnContainer.layoutTransition.setAnimator(LayoutTransition.APPEARING,
            AnimatorInflater.loadAnimator(this, R.animator.animator))

        btnAdd.setOnClickListener {
            val button = Button(this)
            button.text = "Button"

            // set the scale to zero the buttons to be correctly displayed
            button.scaleX = 0f
            button.scaleY = 0f

            btnContainer.addView(button)
        }

        btnRemove.setOnClickListener {
            // the verification is needed, NPE otherwise
            if (btnContainer.childCount != 0) {
                btnContainer.removeViewAt(btnContainer.childCount - 1)
            }
        }
    }

    private fun initViews() {
        btnContainer = findViewById(R.id.btn_container)

        btnAdd = findViewById(R.id.btn_add)
        btnRemove = findViewById(R.id.btn_remove)
    }
}