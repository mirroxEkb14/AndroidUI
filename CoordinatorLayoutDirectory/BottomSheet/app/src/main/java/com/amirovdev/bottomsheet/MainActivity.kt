package com.amirovdev.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // объект класса BottomSheetBehaviour, который и отвечает за все действия с ним
        val bottomSheetBehavior = BottomSheetBehavior.from(bottom_view)

        // действие доставания BottomSheet после его смахивания с экрана
        fab.setOnClickListener {
            // STATE_COLLAPSED -> BottomSheet свернут и есть "язычок"
            // STATE_EXPANDED -> BottomSheet развернут
            // STATE_HIDDEN -> BottomSheet скрыт на экране
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        // эффект затемнения заднкего фона
        bottomSheetBehavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {}

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                tint_black.alpha = slideOffset / 1.5f
            }
        })
    }

    private fun getCallbacksFromBottomSheet(bottomSheetBehavior: BottomSheetBehavior<LinearLayout>) {
        // get callbacks
        bottomSheetBehavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
            // change the button size
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                fab.scaleX = 1 - slideOffset
                fab.scaleY = 1 - slideOffset
            }

            // check the states
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                BottomSheetBehavior.STATE_COLLAPSED //BottomSheet раскрыт только на peekHeight

                BottomSheetBehavior.STATE_DRAGGING //BottomSheet в движении

                BottomSheetBehavior.STATE_EXPANDED //BottomSheet раскрыт

                BottomSheetBehavior.STATE_HIDDEN //BottomSheet скрыт

                BottomSheetBehavior.STATE_SETTLING //BottomSheet автоматически закрывается/раскрывается после того, как вы потянули и отпустили

                BottomSheetBehavior.STATE_HALF_EXPANDED //BottomSheet раскрыт наполовину
            }
        })
    }
}