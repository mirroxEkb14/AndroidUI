package com.amirovdev.scrollingpractice.model

import androidx.annotation.DrawableRes
import com.amirovdev.scrollingpractice.model.Item

class Product(val id: Int, @DrawableRes val idIcon: Int, val name: String, val desc: String) : Item