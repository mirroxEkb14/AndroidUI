package com.amirovdev.viewpageranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.amirovdev.viewpageranimation.adapter.ViewPagerAdapter
import com.amirovdev.viewpageranimation.model.PagerItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Создаем адаптер
        val pagerAdapter = ViewPagerAdapter()

        //Привязываем созданный адаптер к нашему ViewPager, который у нас в разметке
        viewPager2.adapter = pagerAdapter

        //Создаем список элементов, который передадим в адаптер
        val pagerItems = listOf(
            PagerItem(ContextCompat.getDrawable(this, R.drawable.god_of_war_1)!!, "God of War 1"),
            PagerItem(ContextCompat.getDrawable(this, R.drawable.god_of_war_2)!!, "God of War 2"),
            PagerItem(ContextCompat.getDrawable(this, R.drawable.god_of_war_3)!!, "God of War 3")
        )

        //Передаем список в адаптер
        pagerAdapter.setItems(pagerItems)

        /* animate transitions between screens (parallax effect) */
        // page -> is the ViewPager
        viewPager2.setPageTransformer { page, position ->
            val pagerWidth = page.width
            page.textView.translationX = -position * (pagerWidth / 2)
        }
    }
}