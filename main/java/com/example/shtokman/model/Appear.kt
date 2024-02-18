package com.example.shtokman.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Appearences")
data class Appear(
    var creatorID: String,
    var year: Int,
    var month: Int,
    var day: Int,
    var comeIn: String,
    var comeOut: String,
    var today_hours: String,
    var hours_extra: String
): Parcelable
{
    @PrimaryKey(autoGenerate = true)
    var appearID: Long = 0
}