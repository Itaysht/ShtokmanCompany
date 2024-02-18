package com.example.shtokman.update

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.shtokman.model.Workers
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class Workers_updateArgs(
  public val currentWorker: Workers
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Workers::class.java)) {
      result.putParcelable("currentWorker", this.currentWorker as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Workers::class.java)) {
      result.putSerializable("currentWorker", this.currentWorker as Serializable)
    } else {
      throw UnsupportedOperationException(Workers::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Workers::class.java)) {
      result.set("currentWorker", this.currentWorker as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Workers::class.java)) {
      result.set("currentWorker", this.currentWorker as Serializable)
    } else {
      throw UnsupportedOperationException(Workers::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): Workers_updateArgs {
      bundle.setClassLoader(Workers_updateArgs::class.java.classLoader)
      val __currentWorker : Workers?
      if (bundle.containsKey("currentWorker")) {
        if (Parcelable::class.java.isAssignableFrom(Workers::class.java) ||
            Serializable::class.java.isAssignableFrom(Workers::class.java)) {
          __currentWorker = bundle.get("currentWorker") as Workers?
        } else {
          throw UnsupportedOperationException(Workers::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentWorker == null) {
          throw IllegalArgumentException("Argument \"currentWorker\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentWorker\" is missing and does not have an android:defaultValue")
      }
      return Workers_updateArgs(__currentWorker)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): Workers_updateArgs {
      val __currentWorker : Workers?
      if (savedStateHandle.contains("currentWorker")) {
        if (Parcelable::class.java.isAssignableFrom(Workers::class.java) ||
            Serializable::class.java.isAssignableFrom(Workers::class.java)) {
          __currentWorker = savedStateHandle.get<Workers?>("currentWorker")
        } else {
          throw UnsupportedOperationException(Workers::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentWorker == null) {
          throw IllegalArgumentException("Argument \"currentWorker\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentWorker\" is missing and does not have an android:defaultValue")
      }
      return Workers_updateArgs(__currentWorker)
    }
  }
}
