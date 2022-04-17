package com.amirovdev.animationlistener

import android.animation.Animator
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * The point of AnimationListener is that we can get Callbacks
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationUpdateListener = object: Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
                Toast.makeText(this@MainActivity, "Animation repeat", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationEnd(p0: Animator?) {
                Toast.makeText(this@MainActivity, "Animation End", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationCancel(p0: Animator?) {
                Toast.makeText(this@MainActivity, "Animation cancel", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationStart(p0: Animator?) {
                Toast.makeText(this@MainActivity, "Animation start", Toast.LENGTH_SHORT).show()
            }
        }

        button.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(rocket, View.TRANSLATION_Y, 0F, -1000F) // 2450F
            anim.duration = 1000
            anim.addListener(animationUpdateListener)
            anim.start()
        }
    }
}