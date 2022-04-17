package com.amirovdev.appbarlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Literally, AppBarLayout is a vertical LinearLayout but created especially for
 * CoordinatorLayout to use some animations.
 *
 * Several flags for 'app:layout_scrollFlags' attribute in CollapsingToolbarLayout
 * -> "scroll|enterAlways|enterAlwaysCollapsed" When scrolling down, we remove our AppBarLayout
 * completely, but when we scroll up, the Toolbar will appear and when we reach the top,
 * our View will be completely opened.
 * Such functionality is convenient to use, for example, with a search field or buttons that
 * the user will want to use often, and there is no need to hide them from him.
 * In this case Toolbar must have ' app:layout_collapseMode="pin" '
 *
 * -> "scroll|snap" If the AppBarLayout is closed and we start expanding it by opening less than 50%,
 * it will collapse back to the top. If it is expanded and we want to collapse it, having collapsed
 * by less than 50%, it will expand again
 *
 *
 * All these Views know about each other thanks to Behaviours. All the classes are inherited from
 * Coordinator.Behaviours<V>, where <V> is out View. For behavior description several methods
 * are used, but there are 3 main ones:
 * - public boolean layoutDependsOn(...) Checks what view the dependence will be created with
 * - public boolean onDependentViewChanged(...) Checks the changes what happened in View from which there is a dependence
 * - public void onDependentViewRemoved(...) Checks if the View(from which there is a dependence from CoordinatorLayout)
 *                                              is removed
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}