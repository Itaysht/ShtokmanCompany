package com.example.shtokman.worker_page_fragments

import com.example.shtokman.R
import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class filter_appearencesDirections private constructor() {
  private data class ActionFilterAppearencesToWorkersAppearences(
    public val name: String = "כולם",
    public val day: Int = 0,
    public val month: Int = 0,
    public val year: Int = 0
  ) : NavDirections {
    public override val actionId: Int = R.id.action_filter_appearences_to_workers_appearences

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("name", this.name)
        result.putInt("day", this.day)
        result.putInt("month", this.month)
        result.putInt("year", this.year)
        return result
      }
  }

  public companion object {
    public fun actionFilterAppearencesToWorkersAppearences(
      name: String = "כולם",
      day: Int = 0,
      month: Int = 0,
      year: Int = 0
    ): NavDirections = ActionFilterAppearencesToWorkersAppearences(name, day, month, year)
  }
}
