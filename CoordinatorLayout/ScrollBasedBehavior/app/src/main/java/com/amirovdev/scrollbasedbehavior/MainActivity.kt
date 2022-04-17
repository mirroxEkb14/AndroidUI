package com.amirovdev.scrollbasedbehavior

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * CollapsingToolbarLayout has two attributes 'app:layout_scrollFlags' & 'app:layout_collapseMode'.
 *
 * 'app:layout_scrollFlags' sets the type of 'collapse'. Flags can be combined with | symbol
 * -> "scroll" When scrolling up - View is removed, scrolling down - View is opened up but only when the scroll ends
 *
 * -> "scroll|enterAlways" Like "scroll" but when scrolling down - it will be opened up
 * regardless of whether the scroll has reached the end
 *
 * -> "scroll|exitUntilCollapsed" When scrolling up, the Toolbar will not hide completely,
 * when scrolling down, it will open when the end of the View is reached
 *
 */

/**
 * Toolbar has 'layout_collapseMode' that sets the effect that will be applied when the View is minimized when scrolling
 * -> "parallax" The effect of multiplicity, use it when you have a picture
 * -> "pin" just swerves at the same speed as the scroll
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}