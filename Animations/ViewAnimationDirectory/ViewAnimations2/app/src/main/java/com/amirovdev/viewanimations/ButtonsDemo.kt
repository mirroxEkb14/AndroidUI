package com.amirovdev.viewanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_buttons_demo.*

class ButtonsDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons_demo)

        switch_to_animals_btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // animations
        fade_in.setOnClickListener {
            main_text_view.visibility = View.VISIBLE

            val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            main_text_view.startAnimation(animation)
        }

        fade_out.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            main_text_view.startAnimation(animation)

            // remove the View after the animation
            Handler().postDelayed({main_text_view.visibility = View.GONE}, 2000)
        }

        zoom_in.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
            main_text_view.startAnimation(animation)
        }

        zoom_out.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
            main_text_view.startAnimation(animation)
        }

        slide_down.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_down)
            main_text_view.startAnimation(animation)
        }

        slide_up.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
            main_text_view.startAnimation(animation)
        }

        bounce.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            main_text_view.startAnimation(animation)
        }

        rotate.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
            main_text_view.startAnimation(animation)
        }
    }
}