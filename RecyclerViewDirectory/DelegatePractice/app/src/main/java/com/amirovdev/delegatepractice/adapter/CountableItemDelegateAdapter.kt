package com.amirovdev.delegatepractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.delegatepractice.R
import com.amirovdev.delegatepractice.model.CountableItem
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.skill_factory.unit5.model.Item

class CountableItemDelegateAdapter :
    AbsListItemAdapterDelegate<CountableItem, Item, CountableItemDelegateAdapter.CountableItemViewHolder>() {

    class CountableItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ciIcon = itemView.findViewById<ImageView>(R.id.ci_icon)
        val ciCount = itemView.findViewById<TextView>(R.id.ci_count)
        val ciTextName = itemView.findViewById<TextView>(R.id.ci_text_name)
        val ciTextDesc = itemView.findViewById<TextView>(R.id.ci_text_desc)
    }

    override fun isForViewType(item: Item, items: MutableList<Item>, position: Int): Boolean {
        return item is CountableItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): CountableItemViewHolder {
        return CountableItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.countable_item, parent, false))
    }

    override fun onBindViewHolder(
        item: CountableItem,
        holder: CountableItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.ciIcon.setImageResource(item.idIcon)
        holder.ciCount.text = item.count
        holder.ciTextName.text = item.name
        holder.ciTextDesc.text = item.desc
    }
}