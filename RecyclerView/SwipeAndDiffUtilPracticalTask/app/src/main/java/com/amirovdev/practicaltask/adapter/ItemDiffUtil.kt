package com.amirovdev.practicaltask.adapter

import androidx.recyclerview.widget.DiffUtil
import com.amirovdev.practicaltask.model.Item

class ItemDiffUtil(val oldList: List<Item>, val newList: List<Item>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}