package com.example.shtokman.worker_page_fragments

import com.example.shtokman.R
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class Workers_add_pageDirections private constructor() {
  public companion object {
    public fun actionWorkersAddPageToWorkersPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workers_add_page_to_workers_page)

    public fun actionWorkersAddPageToFacultyPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workers_add_page_to_faculty_page)
  }
}
