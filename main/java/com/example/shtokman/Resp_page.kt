package com.example.shtokman

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Resp_page : Fragment(R.layout.fragment_resp) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val but: Button = view.findViewById<Button>(R.id.button_back_resp)
        but.setOnClickListener {
            val action_3 = Resp_pageDirections.actionRespPageToHomePage2()
            findNavController().navigate(action_3)
        }
    }
}