package com.amirovdev.animationsequence2

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var imgSun: ImageView
    private lateinit var imgCloud1: ImageView
    private lateinit var imgCloud2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animatorSet = AnimatorSet()
        initViews()

        val objectSunAnimator = ObjectAnimator.ofFloat(imgSun, View.TRANSLATION_Y, -1300f)
        objectSunAnimator.duration = 1700

        val objectCloud1Animator = ObjectAnimator.ofFloat(imgCloud1, View.TRANSLATION_X, -1000f, 100f)
        objectCloud1Animator.duration = 1800

        val objectCloud2Animator = ObjectAnimator.ofFloat(imgCloud2, View.TRANSLATION_X, 1000f, -100f)
        objectCloud2Animator.duration = 1800

        animatorSet.play(objectSunAnimator)
        animatorSet.play(objectCloud1Animator).after(objectSunAnimator)
        animatorSet.play(objectCloud2Animator).after(objectSunAnimator)

        animatorSet.start()
    }

    private fun initViews() {
        imgSun = findViewById(R.id.img_sun)
        imgCloud1 = findViewById(R.id.img_cloud1)
        imgCloud2 = findViewById(R.id.img_cloud2)
    }
}