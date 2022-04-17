package com.amirovdev.itemanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.itemanimation.adapter.Adapter
import com.amirovdev.itemanimation.model.Fruit

/**
 * The animation of appearing items in the RecyclerView
 *
 * Note:
 * those items that are not seen by users are not animated
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun getItems(): ArrayList<Fruit> {
            return arrayListOf(
                Fruit(
                    0,
                    R.drawable.apple,
                    "Apple",
                    "Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today. Apples have been grown for thousands of years in Asia and Europe and were brought to North America by European colonists"
                ),
                Fruit(
                    1,
                    R.drawable.bananas,
                    "Bananas",
                    "A banana is an elongated, edible fruit – botanically a berry[1][2] – produced by several kinds of large herbaceous flowering plants in the genus Musa.[3] In some countries, bananas used for cooking may be called \"plantains\", distinguishing them from dessert bananas. The fruit is variable in size, color, and firmness, but is usually elongated and curved, with soft flesh rich in starch covered with a rind, which may be green, yellow, red, purple, or brown when ripe."
                ),
                Fruit(
                    2,
                    R.drawable.lemon,
                    "Lemon",
                    "The lemon (Citrus limon) is a species of small evergreen tree in the flowering plant family Rutaceae, native to Asia, primarily Northeast India (Assam), Northern Myanmar or China.[2]\n" +
                            "\n" +
                            "The tree's ellipsoidal yellow fruit is used for culinary and non-culinary purposes throughout the world, primarily for its juice, which has both culinary and cleaning uses.[2] The pulp and rind are also used in cooking and baking."
                ),
                Fruit(
                    3,
                    R.drawable.orange_juice,
                    "Orange Juice",
                    "The orange is the fruit of various citrus species in the family Rutaceae (see list of plants known as orange); it primarily refers to Citrus × sinensis,[1] which is also called sweet orange, to distinguish it from the related Citrus × aurantium, referred to as bitter orange. The sweet orange reproduces asexually (apomixis through nucellar embryony); varieties of sweet orange arise through mutations."
                ),
                Fruit(
                    4,
                    R.drawable.strawberry,
                    "Strawberry",
                    "The garden strawberry (or simply strawberry; Fragaria × ananassa)[1] is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries, which are cultivated worldwide for their fruit. The fruit is widely appreciated for its characteristic aroma, bright red color, juicy texture, and sweetness. It is consumed in large quantities, either fresh or in such prepared foods as jam, juice, pies, ice cream, milkshakes, and chocolates. Artificial strawberry flavorings and aromas are also widely used in products such as candy, soap, lip gloss, perfume, and many others."
                ),
                Fruit(
                    5,
                    R.drawable.watermelon,
                    "Watermelon",
                    "Watermelon (Citrullus lanatus) is a flowering plant species of the Cucurbitaceae family and the name of its edible fruit. A scrambling and trailing vine-like plant, it was originally domesticated in Africa. It is a highly cultivated fruit worldwide, with more than 1,000 varieties.\n" +
                            "\n" +
                            "Wild watermelon seeds have been found in the prehistoric Libyan site of Uan Muhuggiag.[2] There is also evidence from seeds in Pharaoh tombs of watermelon cultivation in Ancient Egypt."
                )
            )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = Adapter(getItems())
        recyclerView.adapter = adapter

        // Load the animation, created in .xml file
        val anim = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation)
        // Pass it to the RecyclerView
        recyclerView.layoutAnimation = anim
        // Start the animation
        recyclerView.scheduleLayoutAnimation()
    }
}