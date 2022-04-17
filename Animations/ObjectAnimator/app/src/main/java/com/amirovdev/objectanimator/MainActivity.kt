package com.amirovdev.objectanimator

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_rocket_back.setOnClickListener {
            val animTransitionY = ObjectAnimator.ofFloat(img_rocket, View.TRANSLATION_Y, 0F)
            animTransitionY.duration = 1000
            animTransitionY.start()

            val animTransitionX = ObjectAnimator.ofFloat(img_rocket, View.TRANSLATION_X, 0F)
            animTransitionX.duration = 1000
            animTransitionX.start()

            val animRotationY = ObjectAnimator.ofFloat(img_rocket, View.ROTATION_Y, 0F)
            animRotationY.duration = 1000
            animRotationY.start()

            val animRotationX = ObjectAnimator.ofFloat(img_rocket, View.ROTATION_X, 0F)
            animRotationX.duration = 1000
            animRotationX.start()

            val animScaleY = ObjectAnimator.ofFloat(img_rocket, View.SCALE_Y, 1F)
            animScaleY.duration = 1000
            animScaleY.start()

            val animScaleX = ObjectAnimator.ofFloat(img_rocket, View.SCALE_X, 1F)
            animScaleX.duration = 1000
            animScaleX.start()
        }

        btn_up.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.TRANSLATION_Y, 0F, -1000F)
            anim.duration = 1000
            anim.start()
        }

        btn_down.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.TRANSLATION_Y, 0F, 1000F)
            anim.duration = 1000
            anim.start()
        }

        btn_left.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.TRANSLATION_X, 0F, -1000F)
            anim.duration = 1000
            anim.start()
        }

        btn_right.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.TRANSLATION_X, 0F, 1000F)
            anim.duration = 1000
            anim.start()
        }

        btn_rotateX1.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.ROTATION_X, 0F, -730F)
            anim.duration = 1000
            anim.start()
        }

        btn_rotateX2.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.ROTATION_X, 0F, 1000F)
            anim.duration = 1000
            anim.start()
        }

        btn_rotateY1.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.ROTATION_Y, 0F, 1000F)
            anim.duration = 1000
            anim.start()
        }

        btn_rotateY2.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.ROTATION_Y, 0F, 1000F)
            anim.duration = 1000
            anim.start()
        }

        btn_transition1.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.ALPHA, 0F)
            anim.duration = 1000
            anim.start()
        }

        btn_transition2.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.ALPHA, 1F)
            anim.duration = 1000
            anim.start()
        }

        btn_scaleX.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.SCALE_X, 0.5F)
            anim.duration = 1000
            anim.start()
        }

        btn_scaleY.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(img_rocket, View.SCALE_Y, 0.5F)
            anim.duration = 1000
            anim.start()
        }
    }
}