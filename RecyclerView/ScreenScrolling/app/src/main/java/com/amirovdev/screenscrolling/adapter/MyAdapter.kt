package com.amirovdev.screenscrolling.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.screenscrolling.R

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    val colors = arrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.WHITE, Color.YELLOW)

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView.findViewById<TextView>(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.page, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setBackgroundColor(colors[position])
        holder.textView.text = "${position + 1}"
    }

    override fun getItemCount(): Int {
        return colors.size
    }
}