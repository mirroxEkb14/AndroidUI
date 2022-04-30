package com.amirovdev.diffutil.adapter

import androidx.recyclerview.widget.DiffUtil
import com.amirovdev.diffutil.model.Product

class ProductDiff(val oldList: ArrayList<Product>, val newList: ArrayList<Product>) : DiffUtil.Callback()  {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    // the items are the same when their ids are the same
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    // the contents of the items are the same when all their fields are the same
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]

        return old.idIcon == new.idIcon &&
                old.name == new.name &&
                old.desc == new.desc
    }
}