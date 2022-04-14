package com.amirovdev.animationsequence1

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var frameAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.img_cat)
        imageView.setBackgroundResource(R.drawable.frame_animation)
        frameAnimation = imageView.background as AnimationDrawable

        findViewById<Button>(R.id.btn_start_stop).setOnClickListener {
            startStopAnimation(imageView)
        }
    }

    private fun startStopAnimation(view: View) {
        when(frameAnimation.isRunning) {
            true -> frameAnimation.stop()
            false -> frameAnimation.start()
        }
    }

    private fun oldMethod() {
        // create an instance of the AndroidDrawable class
        val ad = getResources().getDrawable(R.drawable.frame_animation) as AnimationDrawable

        // add to ImageView and start the animation
        findViewById<ImageView>(R.id.img_cat).setBackgroundDrawable(ad)
        ad.start()
    }
}