package com.amirovdev.viewanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView

/**
 * The use of Animations class.
 * When the animation is finished, the View is located in that place,
 * where the animation finished(View features are not changed)
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // translate square
        val translateAnim = AnimationUtils.loadAnimation(this, R.anim.translate_anim)
        findViewById<ImageView>(R.id.translate_square).startAnimation(translateAnim)

        // alpha square
        val alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha_anim)
        findViewById<ImageView>(R.id.alpha_square).startAnimation(alphaAnim)

        // scale square
        val scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale_anim)
        findViewById<ImageView>(R.id.scale_square).startAnimation(scaleAnim)

        // rotate square
        val rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim)
        findViewById<ImageView>(R.id.rotate_square).startAnimation(rotateAnim)

        // pusheen cat
        val pucheenCatAnim = AnimationUtils.loadAnimation(this, R.anim.pusheen_cat_anim)
        findViewById<ImageView>(R.id.pusheen_cat).setOnClickListener {
            it.startAnimation(pucheenCatAnim)
        }

        // rocket
        val rocketAnim = AnimationUtils.loadAnimation(this, R.anim.rocket_anim)
        findViewById<ImageView>(R.id.rocket).setOnClickListener {
            it.startAnimation(rocketAnim)
        }
    }
}