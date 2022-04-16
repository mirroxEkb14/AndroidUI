package com.amirovdev.snaphelper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.snaphelper.R
import com.amirovdev.snaphelper.model.Fruit
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter(val data: ArrayList<Fruit>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon = itemView.icon
        val text_name = itemView.text_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.icon.setImageResource(data[position].idIcon)
        holder.text_name.text = data[position].name
    }

    override fun getItemCount(): Int {
        return data.size
    }
}