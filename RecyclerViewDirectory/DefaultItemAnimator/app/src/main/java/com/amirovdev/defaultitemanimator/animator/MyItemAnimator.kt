package com.amirovdev.defaultitemanimator.animator

import android.content.Context
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.defaultitemanimator.R

class MyItemAnimator(private val context: Context) : DefaultItemAnimator() {
    // read the animation (the items will appear from the right side of the screen)
    val animAdd = AnimationUtils.loadAnimation(context, R.anim.slide_from_right)
    // when we remove an item, it will move to the right side of the screen
    val animRemove = AnimationUtils.loadAnimation(context, R.anim.slide_to_right)

    override fun onAddStarting(item: RecyclerView.ViewHolder?) {
        // get the access to the View and start the animation
        item?.itemView?.startAnimation(animAdd)
    }

    override fun getAddDuration(): Long {
        return animAdd.duration
    }

    override fun onRemoveStarting(item: RecyclerView.ViewHolder?) {
        item?.itemView?.startAnimation(animRemove)
    }

    override fun getRemoveDuration(): Long {
        return animRemove.duration
    }
}