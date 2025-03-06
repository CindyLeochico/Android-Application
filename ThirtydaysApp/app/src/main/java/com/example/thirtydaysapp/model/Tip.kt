package com.example.thirtydaysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip (
    @StringRes val stringResourcesId: Int,
    @DrawableRes val imageResourceId: Int
)