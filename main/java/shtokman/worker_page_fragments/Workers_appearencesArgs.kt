package com.example.shtokman.worker_page_fragments

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmStatic

public data class Workers_appearencesArgs(
  public val name: String = "כולם",
  public val day: Int = 0,
  public val month: Int = 0,
  public val year: Int = 0
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("name", this.name)
    result.putInt("day", this.day)
    result.putInt("month", this.month)
    result.putInt("year", this.year)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("name", this.name)
    result.set("day", this.day)
    result.set("month", this.month)
    result.set("year", this.year)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): Workers_appearencesArgs {
      bundle.setClassLoader(Workers_appearencesArgs::class.java.classLoader)
      val __name : String?
      if (bundle.containsKey("name")) {
        __name = bundle.getString("name")
        if (__name == null) {
          throw IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.")
        }
      } else {
        __name = "כולם"
      }
      val __day : Int
      if (bundle.containsKey("day")) {
        __day = bundle.getInt("day")
      } else {
        __day = 0
      }
      val __month : Int
      if (bundle.containsKey("month")) {
        __month = bundle.getInt("month")
      } else {
        __month = 0
      }
      val __year : Int
      if (bundle.containsKey("year")) {
        __year = bundle.getInt("year")
      } else {
        __year = 0
      }
      return Workers_appearencesArgs(__name, __day, __month, __year)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): Workers_appearencesArgs {
      val __name : String?
      if (savedStateHandle.contains("name")) {
        __name = savedStateHandle["name"]
        if (__name == null) {
          throw IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value")
        }
      } else {
        __name = "כולם"
      }
      val __day : Int?
      if (savedStateHandle.contains("day")) {
        __day = savedStateHandle["day"]
        if (__day == null) {
          throw IllegalArgumentException("Argument \"day\" of type integer does not support null values")
        }
      } else {
        __day = 0
      }
      val __month : Int?
      if (savedStateHandle.contains("month")) {
        __month = savedStateHandle["month"]
        if (__month == null) {
          throw IllegalArgumentException("Argument \"month\" of type integer does not support null values")
        }
      } else {
        __month = 0
      }
      val __year : Int?
      if (savedStateHandle.contains("year")) {
        __year = savedStateHandle["year"]
        if (__year == null) {
          throw IllegalArgumentException("Argument \"year\" of type integer does not support null values")
        }
      } else {
        __year = 0
      }
      return Workers_appearencesArgs(__name, __day, __month, __year)
    }
  }
}
