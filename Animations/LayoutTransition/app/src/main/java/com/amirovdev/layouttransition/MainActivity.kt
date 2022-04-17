package com.amirovdev.layouttransition

import android.animation.AnimatorInflater
import android.animation.LayoutTransition
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Теперь у добавленной кнопки при изменении размера кнопки будет анимировоно увеличение кнопки
        layout_btn_container.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        btn_add.setOnClickListener {
            val button = Button(this)
            button.text = "BUTTON"

            layout_btn_container.addView(button)
        }

        btn_remove.setOnClickListener {
            if(layout_btn_container.childCount != 0) {
                layout_btn_container.removeViewAt(layout_btn_container.childCount - 1)
            }
        }

        // add your own animation to the view appearing
        layout_btn_container2.layoutTransition.setAnimator(
            LayoutTransition.APPEARING, AnimatorInflater.loadAnimator(this, R.animator.animator))

        btn_add2.setOnClickListener {
            val button = Button(this)
            button.text = "BUTTON"

            button.scaleX = 0f
            button.scaleY = 0f
            layout_btn_container2.addView(button)
        }

        btn_remove2.setOnClickListener {
            if(layout_btn_container2.childCount != 0) {
                layout_btn_container2.removeViewAt(layout_btn_container2.childCount - 1)
            }
        }
    }
}