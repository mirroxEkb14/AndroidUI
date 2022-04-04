package com.amirovdev.viewpager2

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * Passes the data from PagerItem to item.xml(for ViewPager)
 */

class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //В этом методе мы передаем данные из PagerItem в нашу верстку item.xml
    fun onBind(item: PagerItem) {
        //корневой элемент item.xml
        itemView.findViewById<ConstraintLayout>(R.id.container).setBackgroundColor(item.color)
        //Текстовое поле
        itemView.findViewById<AppCompatTextView>(R.id.textView).text = item.text
    }
}