package com.amirovdev.practicaltask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.practicaltask.R
import com.amirovdev.practicaltask.adapter.ProductAdapter
import com.amirovdev.practicaltask.decoration.MyItemDecoration
import com.amirovdev.practicaltask.model.Ad
import com.amirovdev.practicaltask.model.Item
import com.amirovdev.practicaltask.model.Product
import com.amirovdev.practicaltask.touch_helper.ItemTouchHelperCallback

/**
 * Удаление элемента из списка свайпом вправо.
 * Оповещение RecyclerView об изменении данных с помощью DiffUtil.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val adapter = ProductAdapter()
        fun getItems(): ArrayList<Item> {
            return arrayListOf(
                Product(
                    0,
                    R.drawable.ic_apple,
                    "Apple",
                    "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
                ),
                Ad(0, "Акция", "Скидка на бананы 15%"),
                Product(
                    1,
                    R.drawable.ic_banana,
                    "Banana",
                    "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
                ),
                Product(
                    2,
                    R.drawable.ic_lemon,
                    "Lemon",
                    "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
                ),
                Product(
                    3,
                    R.drawable.ic_pear,
                    "Pear",
                    "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
                ),
                Product(
                    4,
                    R.drawable.ic_strawberry,
                    "Strawberry",
                    "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."
                ),
                Ad(1,"Акция", "Товар недели - Груши"),
                Product(
                    5,
                    R.drawable.ic_pear,
                    "Pear",
                    "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
                ),
                Product(
                    6,
                    R.drawable.ic_pear,
                    "Pear",
                    "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
                ),
                Product(
                    7,
                    R.drawable.ic_pear,
                    "Pear",
                    "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
                ),
                Product(
                    8,
                    R.drawable.ic_orange,
                    "Orange",
                    "Orange juice is widely used as a drink in restaurants and cafes."
                ), Product(
                    9,
                    R.drawable.ic_orange,
                    "Orange",
                    "Orange juice is widely used as a drink in restaurants and cafes."
                ),
                Ad(2, "Акция", "Апельсины очень полезны"),
                Product(
                    10,
                    R.drawable.ic_orange,
                    "Orange",
                    "Orange juice is widely used as a drink in restaurants and cafes."
                ), Product(
                    11,
                    R.drawable.ic_orange,
                    "Orange",
                    "Orange juice is widely used as a drink in restaurants and cafes."
                )
            )
        }

        adapter.items = getItems()
        recyclerView.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        val myItemDecoration = MyItemDecoration(this);
        recyclerView.addItemDecoration(myItemDecoration)

        val itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(adapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}
