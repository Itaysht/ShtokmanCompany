package com.example.shtokman

import android.app.Notification
import android.content.Intent
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.Button

import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.example.shtokman.login.Login_activity
//import kotlinx.android.synthetic.main.fragment_home_page.button_calc
//import kotlinx.android.synthetic.main.fragment_home_page.button_resp
//import kotlinx.android.synthetic.main.fragment_home_page.button_sketch
//import kotlinx.android.synthetic.main.fragment_home_page.button_work
//import kotlinx.android.synthetic.main.fragment_home_page.home_page_exit

//import com.example.work.login.Login_activity
//import kotlinx.android.synthetic.main.fragment_home_page.*

class Home_page : Fragment(R.layout.fragment_home_page){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonWork: Button = view.findViewById(R.id.button_work)
        val buttonResp: Button = view.findViewById(R.id.button_resp)
        val buttonCalc: Button = view.findViewById(R.id.button_calc)
        val buttonSketch: Button = view.findViewById(R.id.button_sketch)
        val homePageExit: Button = view.findViewById(R.id.home_page_exit)
        buttonWork.setOnClickListener {
            val action_1 = Home_pageDirections.actionHomePage2ToWorkersPage()
            findNavController().navigate(action_1)
        }
        buttonResp.setOnClickListener {
            val action_4 = Home_pageDirections.actionHomePage2ToRespPage()
            findNavController().navigate(action_4)
        }
        buttonCalc.setOnClickListener {
            val action_6 = Home_pageDirections.actionHomePage2ToCalcPage()
            findNavController().navigate(action_6)
        }
        buttonSketch.setOnClickListener {
            val action_8 = Home_pageDirections.actionHomePage2ToSketchPage()
            findNavController().navigate(action_8)
        }
        homePageExit.setOnClickListener {
            val intent = Intent(activity, Login_activity::class.java).apply {  }
            startActivity(intent)
        }
        }
    }