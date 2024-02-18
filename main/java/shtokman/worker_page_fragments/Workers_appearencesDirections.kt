package com.example.shtokman.worker_page_fragments

import com.example.shtokman.R
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class Workers_appearencesDirections private constructor() {
  public companion object {
    public fun actionWorkersAppearencesToWorkersPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workers_appearences_to_workers_page)

    public fun actionWorkersAppearencesToFilterAppearences(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workers_appearences_to_filter_appearences)
  }
}
