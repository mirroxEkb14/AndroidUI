package com.amirovdev.viewanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val catAnimation = AnimationUtils.loadAnimation(this, R.anim.cat_animation)
        pusheen_cat_img.setOnClickListener {
            pusheen_cat_img.startAnimation(catAnimation)
        }

        val dogAnimation = AnimationUtils.loadAnimation(this, R.anim.dog_animation)
        pusheen_dog_img .setOnClickListener {
            pusheen_dog_img.startAnimation(dogAnimation)
        }

        switch_btn.setOnClickListener {
            val intent = Intent(this, ButtonsDemo::class.java)
            startActivity(intent)
        }
    }
}