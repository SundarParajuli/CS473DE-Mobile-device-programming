package com.sundar.walmartlogin.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val title: String,
    val price: Double,
    val color: String,
    val image: String,
    val itemId: String,
    val desc: String
) : Parcelable
