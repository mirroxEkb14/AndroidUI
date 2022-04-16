package com.amirovdev.recyclerviewoverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Provides the data to the RecyclerView
 */

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    // the data
    lateinit var list: ArrayList <String>

    // creates ViewHolder and returns it
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        // create a View from item.xml
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false)

        // the constructor of ViewHolder takes created View
        return MyViewHolder(view)
    }

    // transfers the data from the model to the performance (position -> index of the list)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // 'holder' in the root performance is a TextView, so we convert it to the TextView
        (holder.itemView as TextView).text = list[position]
    }

    // returns the amount of elements in Adapter
    override fun getItemCount(): Int {
        return list.size
    }

    // ViewHolder is an abstract class, so we need to create an inner class that inherits from ViewHolder
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}