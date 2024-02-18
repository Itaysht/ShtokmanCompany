package com.example.shtokman.update

import com.example.shtokman.R
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class Workers_updateDirections private constructor() {
  public companion object {
    public fun actionWorkersUpdateToFacultyPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workers_update_to_faculty_page)
  }
}
