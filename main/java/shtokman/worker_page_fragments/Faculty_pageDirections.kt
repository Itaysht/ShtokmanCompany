package com.example.shtokman.worker_page_fragments

import com.example.shtokman.R
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.shtokman.model.Workers
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class Faculty_pageDirections private constructor() {
  private data class ActionFacultyPageToWorkersUpdate(
    public val currentWorker: Workers
  ) : NavDirections {
    public override val actionId: Int = R.id.action_faculty_page_to_workers_update

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionFacultyPageToWorkersPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_faculty_page_to_workers_page)

    public fun actionFacultyPageToWorkersUpdate(currentWorker: Workers): NavDirections =
        ActionFacultyPageToWorkersUpdate(currentWorker)
  }
}
