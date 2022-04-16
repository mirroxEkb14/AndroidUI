package com.amirovdev.diffutil

import androidx.recyclerview.widget.DiffUtil

class ProductDiff(val oldList: ArrayList<Product>, val newList: ArrayList<Product>) : DiffUtil.Callback()  {
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
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]

        return old.idIcon == new.idIcon &&
                old.name == new.name &&
                old.desc == new.desc
    }
}