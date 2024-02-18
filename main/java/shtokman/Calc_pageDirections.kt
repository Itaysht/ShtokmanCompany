package com.example.shtokman

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class Calc_pageDirections private constructor() {
  public companion object {
    public fun actionCalcPageToHomePage2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_calc_page_to_home_page2)
  }
}
