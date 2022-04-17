package com.amirovdev.viewpropertyanimation

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * The ViewPropertyAnimation is convenient for animation implementation
 * inside the class based on some logic. If fact, ViewPropertyAnimation is
 * a ValueAnimator and ObjectAnimator but has more comfortable and readable syntax.
 * The View features are changed, meaning that we animate the View by some event
 * (for example, after btn clicking)
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_disappear.setOnClickListener {
            img_main.animate()
                .setDuration(1000)
                .setInterpolator(DecelerateInterpolator())
                .alpha(0f)
                .setListener(object: Animator.AnimatorListener {
                    override fun onAnimationRepeat(p0: Animator?) {
                        Toast.makeText(applicationContext, "Animation Repeats", Toast.LENGTH_SHORT).show()
                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        Toast.makeText(applicationContext, "Animation Ends", Toast.LENGTH_SHORT).show()
                    }

                    override fun onAnimationCancel(p0: Animator?) {
                        Toast.makeText(applicationContext, "Animation Cancels", Toast.LENGTH_SHORT).show()
                    }

                    override fun onAnimationStart(p0: Animator?) {
                        Toast.makeText(applicationContext, "Animation Starts", Toast.LENGTH_SHORT).show()
                    }

                })
                .start()
        }

        // make the image visible
        btn_appear.setOnClickListener {
            img_main.animate()
                .setDuration(1000)
                .setInterpolator(DecelerateInterpolator())
                .alpha(1f)
                .start()
        }
    }
}