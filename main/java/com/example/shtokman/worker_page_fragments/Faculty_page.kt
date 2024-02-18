package com.example.shtokman.worker_page_fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shtokman.R
import com.example.shtokman.viewmodel.WorkersViewModel
import kotlinx.android.synthetic.main.fragment_workers_faculty.*
import kotlinx.android.synthetic.main.fragment_workers_faculty.view.*

class Faculty_page : Fragment(R.layout.fragment_workers_faculty) {

    private lateinit var mWorkerViewModel: WorkersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = Faculty_adapter()
        val recyclerview = view.workers_recycle
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        mWorkerViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)
        mWorkerViewModel.readAllData.observe(viewLifecycleOwner, Observer { worker ->
            adapter.setData(worker)
        })

        val view2 = super.onViewCreated(view, savedInstanceState)

        faculty_back_to_workers.setOnClickListener {
            val action_15 = Faculty_pageDirections.actionFacultyPageToWorkersPage()
            findNavController().navigate(action_15)
        }
        faculty_deleteall.setOnClickListener {
            deleteAllWorkers()
        }
        return view2
    }
    private fun deleteAllWorkers(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("כן"){ _, _ ->
            mWorkerViewModel.delete_all_workers()
            Toast.makeText(requireContext(), "Successfullly removed everyone", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("לא"){ _, _ -> }
        builder.setTitle("מחק את כולם?")
        builder.setMessage("האם אתה בטוח למחוק את כולם?")
        builder.create().show()

    }
}