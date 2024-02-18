package com.example.shtokman

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class Workers_pageDirections private constructor() {
  private data class ActionWorkersPageToWorkersAppearences(
    public val name: String = "כולם",
    public val day: Int = 0,
    public val month: Int = 0,
    public val year: Int = 0
  ) : NavDirections {
    public override val actionId: Int = R.id.action_workers_page_to_workers_appearences

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
    public fun actionWorkersPageToHomePage2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workers_page_to_home_page2)

    public fun actionWorkersPageToWorkersAddPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workers_page_to_workers_add_page)

    public fun actionWorkersPageToFacultyPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workers_page_to_faculty_page)

    public fun actionWorkersPageToWorkersAppearences(
      name: String = "כולם",
      day: Int = 0,
      month: Int = 0,
      year: Int = 0
    ): NavDirections = ActionWorkersPageToWorkersAppearences(name, day, month, year)
  }
}
