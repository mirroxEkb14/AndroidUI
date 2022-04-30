package com.amirovdev.adapterdelegatesnew.model

import androidx.annotation.DrawableRes
import com.amirovdev.adapterdelegatesnew.model.Item

class Product(val id: Int, @DrawableRes val idIcon: Int, val name: String, val desc: String) : Item