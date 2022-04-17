package com.amirovdev.practicaltask.model

import androidx.annotation.DrawableRes
import com.amirovdev.practicaltask.model.Item

class Product(override val id: Int, @DrawableRes val idIcon: Int, val name: String, val desc: String) : Item