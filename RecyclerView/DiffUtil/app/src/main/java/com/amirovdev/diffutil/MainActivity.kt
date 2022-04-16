package com.amirovdev.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * We make some changes to our RecyclerView dataset, we call the 'notifyDataSetChanged()' method
 * to notify the adapter about the changes. It causes RecyclerView to flicker. RecyclerView
 * flickers because the adapter makes all the dataset invalid, so that RecyclerViewPool creates them again
 *
 * DiffUtil is a class that allows adapter to automatically determine what list cells are needed to update.
 * We do not need to follow element indexes or think about performance, DiffUtil does all this by itself
 * with the help of mathematical algorithms and uses point calls of the 'notify' method. All we need to do
 * is: realize DiffUtil.Callback, calculate Diff and tell it the adapter
 */

class MainActivity : AppCompatActivity() {

    private lateinit var itemIndex: EditText
    private lateinit var add: Button
    private lateinit var change: Button
    private lateinit var remove: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ProductAdapter(arrayListOf(
            Product(0, R.drawable.ic_apple, "Apple", "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."),
            Product(1, R.drawable.ic_banana, "Banana", "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."),
            Product(2, R.drawable.ic_lemon, "Lemon", "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."),
            Product(3, R.drawable.ic_pear, "Pear", "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."),
            Product(4, R.drawable.ic_strawberry, "Strawberry", "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."),
            Product(5, R.drawable.ic_orange, "Orange", "Orange juice is widely used as a drink in restaurants and cafes.")
        ))
        recyclerView.adapter = adapter

        initViews()
        fun getIndex(): Int =
            itemIndex.text.toString().toInt()

        fun updateData(newList: ArrayList<Product>) {
            val oldList = adapter.data
            val productDiff = ProductDiff(oldList, newList)
            val diffResult = DiffUtil.calculateDiff(productDiff)
            adapter.data = newList
            diffResult.dispatchUpdatesTo(adapter)
        }

        add.setOnClickListener {
            val newList = arrayListOf<Product>()
            newList.addAll(adapter.data)
            newList.add(getIndex(), Product(adapter.data.size, R.drawable.ic_apple, "Apple", "Desc"))
            updateData(newList)
        }
        change.setOnClickListener {
            val newList = arrayListOf<Product>()
            newList.addAll(adapter.data)
            newList[getIndex()] = Product(adapter.data.size, R.drawable.ic_orange, "Orange", "Desc")
            updateData(newList)
        }
        remove.setOnClickListener {
            val newList = arrayListOf<Product>()
            newList.addAll(adapter.data)
            newList.removeAt(getIndex())
            updateData(newList)
        }

    }

    private fun initViews() {
        itemIndex = findViewById(R.id.item_index)
        add = findViewById(R.id.add)
        change = findViewById(R.id.change)
        remove = findViewById(R.id.remove)
    }
}
