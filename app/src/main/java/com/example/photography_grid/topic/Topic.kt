package com.example.photography_grid.topic

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringFileResourceId: Int,
    val intQuantityResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)