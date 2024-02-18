package com.example.shtokman

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Calc_page: Fragment(R.layout.fragment_calc) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val but: Button = view.findViewById<Button>(R.id.button_back_calc)
        but.setOnClickListener {
            val action_5 = Calc_pageDirections.actionCalcPageToHomePage2()
            findNavController().navigate(action_5)
        }
    }
}