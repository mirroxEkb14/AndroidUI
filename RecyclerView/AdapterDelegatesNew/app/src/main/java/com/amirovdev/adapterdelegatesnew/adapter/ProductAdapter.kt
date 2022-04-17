package com.amirovdev.adapterdelegatesnew.adapter

import com.amirovdev.adapterdelegatesnew.model.Item
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ProductAdapter : ListDelegationAdapter<List<Item>>() {

    init {
        delegatesManager.addDelegate(ProductAdapterDelegate())
        delegatesManager.addDelegate(AdDelegateAdapter())
    }

    override fun setItems(items: List <Item>? ) {
        super.setItems(items) // set new list
        notifyDataSetChanged()
    }
}