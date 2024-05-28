package com.example.passtask3

import android.os.Parcelable
import java.io.Serializable
import kotlinx.parcelize.Parcelize


@Parcelize
data class data_record(
    val country: String,
    val ioccode: String,
    val times_competed: Int,
    val gold: Int,
    val silver :Int,
    val bronze: Int): Parcelable, Serializable {}
