package com.amirovdev.practicaltask.touch_helper

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.practicaltask.adapter.ItemDiffUtil
import com.amirovdev.practicaltask.adapter.ProductAdapter
import com.amirovdev.practicaltask.model.Item

class ItemTouchHelperCallback(val adapter: ProductAdapter) : ItemTouchHelper.Callback() {

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        val swipeFlags = ItemTouchHelper.END
        return makeMovementFlags(0, swipeFlags)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val newList = arrayListOf<Item>()
        newList.addAll(adapter.items)
        newList.removeAt(viewHolder.adapterPosition)
        val diff = ItemDiffUtil(adapter.items, newList)
        val difResult = DiffUtil.calculateDiff(diff)
        adapter.items = newList
        difResult.dispatchUpdatesTo(adapter)
    }
}