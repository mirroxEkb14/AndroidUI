package com.amirovdev.viewpageranimation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.viewpageranimation.model.PagerItem
import com.amirovdev.viewpageranimation.R
import kotlinx.android.synthetic.main.item.view.*

/* Contains and passes the data to the ViewHolder */

class ViewPagerAdapter: RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>()  {
    //Здесь хранится список наших объектов с цветом и текстом
    private val items = mutableListOf<PagerItem>()

    //Этот метод возвращает количество элементов в items, иногда полезно
    override fun getItemCount(): Int = items.size

    //В это методе создается VIewHolder и к нему привязывается наш item.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    //В это методы передаются данные из items в layout
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    //Этот метод наполняет список items, нужен нам чтобы делать это извне
    fun setItems(list: List<PagerItem>) {
        items.clear()
        items.addAll(list)
    }

    /* Binds the data from the PagerItem class to the ViewPager(xml file) */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        //В этом методе мы передаем данные из PagerItem в нашу верстку item.xml
        fun onBind(item: PagerItem) {
            //корневой элемент item.xml
            itemView.imageView.setImageDrawable(item.image)
            //Текстовое поле
            itemView.textView.text = item.text
        }
    }
}