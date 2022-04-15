package com.amirovdev.customanimation

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

/**
 * https://beta.shapeshifter.design/
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animPlaceholder = findViewById<ImageView>(R.id.anim_placeholder)
        animPlaceholder.setImageDrawable(this.getDrawable(R.drawable.avd_anim))
        val animation = animPlaceholder.drawable as AnimatedVectorDrawable

        animPlaceholder.setOnClickListener { animation.start() }
    }
}