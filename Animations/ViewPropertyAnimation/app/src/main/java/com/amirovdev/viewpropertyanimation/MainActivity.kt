package com.amirovdev.viewpropertyanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible

/**
 * If fact, ViewPropertyAnimation is a ValueAnimator and ObjectAnimator
 * but has more comfortable and readable syntax. It changes the View features
 */

class MainActivity : AppCompatActivity() {

    private lateinit var btnDisappear: Button
    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        btnDisappear.setOnClickListener {
            img.animate()
                .setDuration(1000)
                .setInterpolator(DecelerateInterpolator())
                .alpha(0f)
                .start()
        }
    }

    private fun initViews() {
        btnDisappear = findViewById(R.id.btn_disappear)
        img = findViewById(R.id.img)
    }
}