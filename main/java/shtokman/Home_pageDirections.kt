package com.example.shtokman

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class Home_pageDirections private constructor() {
  public companion object {
    public fun actionHomePage2ToWorkersPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_page2_to_workers_page)

    public fun actionHomePage2ToRespPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_page2_to_resp_page)

    public fun actionHomePage2ToCalcPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_page2_to_calc_page)

    public fun actionHomePage2ToSketchPage(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_page2_to_sketch_page)
  }
}
