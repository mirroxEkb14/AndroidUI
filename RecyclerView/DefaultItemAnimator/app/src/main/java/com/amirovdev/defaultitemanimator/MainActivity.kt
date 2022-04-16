package com.amirovdev.defaultitemanimator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.defaultitemanimator.adapter.Product
import com.amirovdev.defaultitemanimator.adapter.ProductAdapter
import com.amirovdev.defaultitemanimator.animator.MyItemAnimator

/**
 * This class can animate adding, removing and updating
 * the list elements
 */

class MainActivity : AppCompatActivity() {

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
        recyclerView.itemAnimator = MyItemAnimator(applicationContext)

        findViewById<Button>(R.id.add).setOnClickListener {
            adapter.data.add(Product(adapter.data.size, R.drawable.ic_orange, "Orange", "Orange juice is widely used as a drink in restaurants and cafes."))
            adapter.notifyItemInserted(adapter.data.size - 1)
        }
        findViewById<Button>(R.id.remove).setOnClickListener {
            adapter.data.removeLast()
            adapter.notifyItemRemoved(adapter.data.size)
        }
    }
}
