package com.amirovdev.adapterdelegatesnew.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.adapterdelegatesnew.R
import com.amirovdev.adapterdelegatesnew.model.Item
import com.amirovdev.adapterdelegatesnew.model.Product
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

/**
 * Without creating constants, verifications and transformations
 */

class ProductAdapterDelegate :
    AbsListItemAdapterDelegate<Product, Item, ProductAdapterDelegate.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        val textDesc = itemView.findViewById<TextView>(R.id.text_desc)
    }

    // returns if the item is that we need to process
    override fun isForViewType(item: Item, items: MutableList<Item>, position: Int): Boolean {
        return item is Product
    }

    // create ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(item: Product, holder: ViewHolder, payloads: MutableList<Any>) {
        holder.icon.setImageResource(item.idIcon)
        holder.textName.text = item.name
        holder.textDesc.text = item.desc
    }
}