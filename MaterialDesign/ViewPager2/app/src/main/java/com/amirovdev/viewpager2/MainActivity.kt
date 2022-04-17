package com.amirovdev.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.amirovdev.viewpager2.adapter.ViewPagerAdapter
import com.amirovdev.viewpager2.model.PagerItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Создаем адаптер
        val pagerAdapter = ViewPagerAdapter()

        //Привязываем созданный адаптер к нашему ViewPager, который у нас в разметке
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter = pagerAdapter

        //Создаем список элементов, который передадим в адаптер
        val pagerItems = listOf(
            PagerItem(ContextCompat.getColor(this, R.color.purple_700), "Red"),
            PagerItem(ContextCompat.getColor(this, R.color.teal_200), "Green"),
            PagerItem(ContextCompat.getColor(this, R.color.teal_700), "Yellow")
        )

        //Передаем список в адаптер
        pagerAdapter.setItems(pagerItems)

        // to scroll vertically
//        findViewById<ViewPager2>(R.id.viewPager2).orientation = ViewPager2.ORIENTATION_VERTICAL

        // animating transitions between screens (parallax effect)
        // page -> the current viewPage,
        // position -> we have three images, if we are on the second one, the first has -1, the second - 0, the third - 1
        viewPager2.setPageTransformer { page, position ->
            val pagerWidth = page.width
            page.findViewById<AppCompatTextView>(R.id.textView).translationX = -position * (pagerWidth / 2)
        }
    }
}