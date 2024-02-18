package com.example.shtokman

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Workers_page : Fragment(R.layout.workers_page_x){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val but: Button = view.findViewById<Button>(R.id.button_back)
        but.setOnClickListener {
            val action_2 = Workers_pageDirections.actionWorkersPageToHomePage2()
            findNavController().navigate(action_2)
        }
        val but2: Button = view.findViewById<Button>(R.id.button_add_worker)
        but2.setOnClickListener {
            val action_10 = Workers_pageDirections.actionWorkersPageToWorkersAddPage()
            findNavController().navigate(action_10)
        }
        val but3: Button = view.findViewById<Button>(R.id.button_see_faculty)
        but3.setOnClickListener {
            val action_12 = Workers_pageDirections.actionWorkersPageToFacultyPage()
            findNavController().navigate(action_12)
        }
        val but4: Button = view.findViewById<Button>(R.id.button_appear)
        but4.setOnClickListener {
            val action_23 = Workers_pageDirections.actionWorkersPageToWorkersAppearences()
            findNavController().navigate(action_23)
        }
    }

}