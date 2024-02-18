package com.example.shtokman

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shtokman.viewmodel.WorkersViewModel

class Sketch_page: Fragment(R.layout.fragment_sketch) {
    private lateinit var mWorkerViewModel: WorkersViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mWorkerViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)
        val but: Button = view.findViewById<Button>(R.id.button_back_sketch)
        but.setOnClickListener {
            val action_7 = Sketch_pageDirections.actionSketchPageToHomePage2()
            findNavController().navigate(action_7)
        }
        val but2: Button = view.findViewById<Button>(R.id.help_me)
        but.setOnClickListener {
            mWorkerViewModel.delete_all_appear()
            Toast.makeText(requireContext(), "הכל נמחק", Toast.LENGTH_SHORT).show()
        }
    }
}