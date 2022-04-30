package com.amirovdev.delegatepractice.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.skill_factory.unit5.model.Item

class ProductAdapter() : ListDelegationAdapter<List<Item>>() {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())
        delegatesManager.addDelegate(CountableItemDelegateAdapter())
    }

    override fun setItems(items: List<Item>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}