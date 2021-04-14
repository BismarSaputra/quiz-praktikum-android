package com.example.ayobantu.data.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Food (
    val title: String=" ",
    val thumb: String=" ",
    val tags: String=" ",
    val key: String =" " ) : Parcelable
