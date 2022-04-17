package com.amirovdev.layoutanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switch_to_img_btn.setOnClickListener {
            val intent = Intent(this, ImageAnimation::class.java)
            startActivity(intent)
        }
    }
}