package com.amirovdev.interpolators

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.*
import android.widget.Button
import android.widget.ImageView
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

class MainActivity : AppCompatActivity() {

    private lateinit var img1: ImageView
    private lateinit var btnImg1: Button

    private lateinit var img2: ImageView
    private lateinit var btnImg2: Button

    private lateinit var img3: ImageView
    private lateinit var btnImg3: Button

    private lateinit var img4: ImageView
    private lateinit var btnImg4: Button

    private lateinit var img5: ImageView
    private lateinit var btnImg5: Button

    private lateinit var img6: ImageView
    private lateinit var btnImg6: Button

    private lateinit var img7: ImageView
    private lateinit var btnImg7: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        // Accelerate Decelerate Interpolator (accelerates and slows down)
        val img1Anim = ObjectAnimator.ofFloat(img1, View.TRANSLATION_Y, -200f)
        img1Anim.interpolator = AccelerateDecelerateInterpolator()
        img1Anim.duration = 1000
        btnImg1.setOnClickListener { img1Anim.start() }

        // Accelerate Decelerate Interpolator (accelerates but does not slow down)
        val img2Anim = ObjectAnimator.ofFloat(img2, View.TRANSLATION_Y, -200f)
        img2Anim.interpolator = AccelerateInterpolator()
        img2Anim.duration = 1000
        btnImg2.setOnClickListener { img2Anim.start() }

        // Overshoot interpolator (the effect of flight(перелёт))
        val img3Anim = ObjectAnimator.ofFloat(img3, View.TRANSLATION_Y, -200f)
        img3Anim.interpolator = OvershootInterpolator()
        img3Anim.duration = 1000
        btnImg3.setOnClickListener { img3Anim.start() }

        // Anticipate interpolator (the effect of swing(замах))
        val img4Anim = ObjectAnimator.ofFloat(img4, View.TRANSLATION_Y, -200f)
        img4Anim.interpolator = AnticipateInterpolator()
        img4Anim.duration = 1000
        btnImg4.setOnClickListener { img4Anim.start() }

        // Anticipate Overshoot Interpolator (the effect of swing and flight)
        val img5Anim = ObjectAnimator.ofFloat(img5, View.TRANSLATION_Y, -200f)
        img5Anim.interpolator = AnticipateOvershootInterpolator()
        img5Anim.duration = 1000
        btnImg5.setOnClickListener { img5Anim.start() }

        // Anticipate Overshoot Interpolator (the effect of rebound(отскок))
        val img6Anim = ObjectAnimator.ofFloat(img6, View.TRANSLATION_Y, 60f)
        img6Anim.interpolator = BounceInterpolator()
        img6Anim.duration = 1000
        btnImg6.setOnClickListener { img6Anim.start() }

        // Fast Out Slow In Interpolator (the effect of a sudden move in the end(резкое движение))
        val img7Anim = ObjectAnimator.ofFloat(img7, View.TRANSLATION_Y, 60f)
        img7Anim.interpolator = FastOutSlowInInterpolator()
        img7Anim.duration = 1000
        btnImg7.setOnClickListener { img7Anim.start() }
    }

    private fun initViews() {
        img1 = findViewById(R.id.img1)
        btnImg1 = findViewById(R.id.btn_img1)

        img2 = findViewById(R.id.img2)
        btnImg2 = findViewById(R.id.btn_img2)

        img3 = findViewById(R.id.img3)
        btnImg3 = findViewById(R.id.btn_img3)

        img4 = findViewById(R.id.img4)
        btnImg4 = findViewById(R.id.btn_img4)

        img5 = findViewById(R.id.img5)
        btnImg5 = findViewById(R.id.btn_img5)

        img6 = findViewById(R.id.img6)
        btnImg6 = findViewById(R.id.btn_img6)

        img7 = findViewById(R.id.img7)
        btnImg7 = findViewById(R.id.btn_img7)
    }
}