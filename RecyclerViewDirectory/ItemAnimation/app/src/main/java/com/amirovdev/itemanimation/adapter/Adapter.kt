package com.amirovdev.itemanimation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.itemanimation.R
import com.amirovdev.itemanimation.model.Fruit

class Adapter(private val data: ArrayList<Fruit>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_icon.setImageResource(data[position].idIcon)
        holder.txt_name.text = data[position].name
        holder.txt_desc.text = data[position].desc
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val img_icon = itemView.findViewById<ImageView>(R.id.img_icon)
        val txt_name = itemView.findViewById<TextView>(R.id.txt_name)
        val txt_desc = itemView.findViewById<TextView>(R.id.txt_desc)
    }
}