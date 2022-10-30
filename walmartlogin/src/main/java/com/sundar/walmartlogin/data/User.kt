package com.sundar.walmartlogin.data

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var firstName: String?="",
    var lastName: String?="",
    val userName: String,
    var password: String
):Parcelable
