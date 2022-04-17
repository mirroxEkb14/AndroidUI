package com.amirovdev.recyclerviewoverview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.recyclerviewoverview.R
import com.amirovdev.recyclerviewoverview.model.Game

/**
 * Provides the data to the RecyclerView
 */

class MyAdapter(private val data: ArrayList<Game>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // creates ViewHolder and returns it
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        // create a View from item.xml, the constructor of ViewHolder takes created View
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false))
    }

    // transfers the data from the model to the performance (position -> index of the list)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<ImageView>(R.id.item_img).setImageResource(data[position].idIcon)
        holder.itemView.findViewById<TextView>(R.id.item_title).text = data[position].title
        holder.itemView.findViewById<TextView>(R.id.item_desc).text =  data[position].desc
    }

    // returns the amount of elements in Adapter
    override fun getItemCount(): Int {
        return data.size
    }

    // ViewHolder is an abstract class, so we need to create an inner class that inherits from ViewHolder
    // allows referring to the View (game item)
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImg = itemView.findViewById<ImageView>(R.id.item_img)
        val itemTitle = itemView.findViewById<TextView>(R.id.item_title)
        val itemDesc = itemView.findViewById<TextView>(R.id.item_desc)
    }
}