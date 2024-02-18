package com.example.shtokman.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Workers_info")
data class Workers(
    @PrimaryKey
    val id: String,
    val first_name: String,
    val last_name: String,
    val phone_number: String,
    val paycheck: String,
    val age: String,
    val address: String
): Parcelable