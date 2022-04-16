package com.amirovdev.adapterdelegates.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.adapterdelegates.R
import com.amirovdev.adapterdelegates.model.Ad
import com.amirovdev.adapterdelegates.model.Item
import com.amirovdev.adapterdelegates.model.Product
import java.lang.IllegalArgumentException
import java.util.ArrayList

const val ITEM_VIEW_TYPE_PRODUCT = 0
const val ITEM_VIEW_TYPE_AD = 1

class ProductAdapter(var data: ArrayList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // depending on viewType the method returns corresponding ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_VIEW_TYPE_PRODUCT) {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
        } else if (viewType == ITEM_VIEW_TYPE_AD) {
            return AdViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false))
        } else {
            throw IllegalArgumentException("Invalid viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            data[position] is Product -> {
                ITEM_VIEW_TYPE_PRODUCT
            }
            data[position] is Ad -> {
                ITEM_VIEW_TYPE_AD
            }
            else -> {
                throw IllegalArgumentException("Invalid item view type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ITEM_VIEW_TYPE_PRODUCT) {
            val h = holder as ViewHolder
            val item = data[position] as Product
            h.icon.setImageResource(item.idIcon)
            h.textName.text = item.name
            h.textDesc.text = item.desc
        } else if (getItemViewType(position) == ITEM_VIEW_TYPE_AD) {
            val h = holder as AdViewHolder
            val item = data[position] as Ad
            h.textTitle.text = item.title
            h.textContant.text = item.content
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        val textDesc = itemView.findViewById<TextView>(R.id.text_desc)
    }

    // ViewHodler for Ad
    class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle = itemView.findViewById<TextView>(R.id.title)
        val textContant = itemView.findViewById<TextView>(R.id.content)
    }
}