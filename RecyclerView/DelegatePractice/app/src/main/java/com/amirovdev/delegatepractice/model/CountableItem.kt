package com.amirovdev.delegatepractice.model

import androidx.annotation.DrawableRes
import com.skill_factory.unit5.model.Item

class CountableItem(val id: Int, @DrawableRes val idIcon: Int, val count: String, val name: String, val desc: String) : Item