package com.amirovdev.snaphelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.snaphelper.adapter.MyAdapter
import com.amirovdev.snaphelper.model.Fruit

/**
 * LinearSnapHelper -> the class defined itself on what element the scrolling stopped
 * and brings to the nearest element so that it is fully visible
 *
 * LinearSnapHelper -> it is impossible to jump through several list items at once when
 * scrolling through, when the user releases his finger, it calculates which list item is closest
 * to the centerline of the list and with smooth animation aligns it exactly in the center.
 * Thus, if the swipe is very sharp, the list is scrolled to the next element,
 * otherwise it returns to its original state with animation.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView1 = findViewById<RecyclerView>(R.id.recycler_view1)
        val snapHelper1 = LinearSnapHelper()
        snapHelper1.attachToRecyclerView(recyclerView1)

        fun data() : ArrayList<Fruit> = arrayListOf(
            Fruit(R.drawable.ic_apple, "Apple"),
            Fruit(R.drawable.ic_banana, "Banana"),
            Fruit(R.drawable.ic_lemon, "Lemon"),
            Fruit(R.drawable.ic_orange, "Orange"),
            Fruit(R.drawable.ic_pear, "Pear"),
            Fruit(R.drawable.ic_pear, "Pear1"),
            Fruit(R.drawable.ic_pear, "Pear2"),
            Fruit(R.drawable.ic_pear, "Pear3"),
            Fruit(R.drawable.ic_strawberry, "Strawberry"),
        )

        recyclerView1.adapter = MyAdapter(data())

        val recyclerView2 = findViewById<RecyclerView>(R.id.recycler_view2)
        val snapHelper2 = PagerSnapHelper()
        snapHelper2.attachToRecyclerView(recyclerView2)

        recyclerView2.adapter = MyAdapter(data())
    }
}
