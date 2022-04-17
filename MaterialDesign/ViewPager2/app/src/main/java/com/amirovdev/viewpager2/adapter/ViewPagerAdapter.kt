package com.amirovdev.viewpager2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.viewpager2.model.PagerItem
import com.amirovdev.viewpager2.R

/**
 * Class for management and connection of all items
 */

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    //Здесь хранится список наших объектов с цветом и текстом
    private val items = mutableListOf<PagerItem>()

    //Этот метод мы возвращает количество элементов в items, иногда полезно
    override fun getItemCount(): Int = items.size

    //В это методе создается VIewHolder и к нему привязывается наш item.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    //В это методы передаются данные из items в layout
    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    //Этот метод наполняет список items, нужен нам чтобы делать это извне
    fun setItems(list: List<PagerItem>) {
        items.clear()
        items.addAll(list)
    }

    // Passes the data from PagerItem to item.xml(for ViewPager)
    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //В этом методе мы передаем данные из PagerItem в нашу верстку item.xml
        fun onBind(item: PagerItem) {
            //корневой элемент item.xml
            itemView.findViewById<ConstraintLayout>(R.id.container).setBackgroundColor(item.color)
            //Текстовое поле
            itemView.findViewById<AppCompatTextView>(R.id.textView).text = item.text
        }
    }
}