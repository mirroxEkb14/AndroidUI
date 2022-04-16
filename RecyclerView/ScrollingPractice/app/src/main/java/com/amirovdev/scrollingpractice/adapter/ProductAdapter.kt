package com.amirovdev.scrollingpractice.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.amirovdev.scrollingpractice.model.Item

class ProductAdapter() : ListDelegationAdapter<List<Item>>() {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())
    }

    override fun setItems(items: List<Item>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}