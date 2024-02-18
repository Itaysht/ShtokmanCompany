package com.example.shtokman.worker_page_fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shtokman.R
import com.example.shtokman.model.Workers
import com.example.shtokman.viewmodel.WorkersViewModel
import kotlinx.android.synthetic.main.fragment_workers_add.*

class Workers_add_page: Fragment(R.layout.fragment_workers_add){

    private lateinit var mWorkerViewModel: WorkersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val view = super.onViewCreated(view, savedInstanceState)

        mWorkerViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)

        button_back__workers_save.setOnClickListener {
            insertDataToDatabase()
        }
        button_back__workers_add.setOnClickListener {
            val action_16 = Workers_add_pageDirections.actionWorkersAddPageToWorkersPage()
            findNavController().navigate(action_16)
        }
        return view
    }

    private fun insertDataToDatabase() {
        val first_name = editTextTextPersonName.text.toString()
        val last_name = editTextLastName.text.toString()
        val worker_id = add_worker_id.text.toString()
        val phone_number = add_worker_phone_number.text.toString()
        val paycheck = add_worker_paycheck.text.toString()
        val age = add_worker_age.text.toString()
        val address = add_worker_address.text.toString()

//        if (inputCheck(first_name, last_name, worker_id, phone_number, paycheck, age, address)){
        val worker = Workers(worker_id, first_name, last_name, phone_number, paycheck, age, address)
        mWorkerViewModel.add_worker(worker)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_workers_add_page_to_faculty_page)
//        }
//        else{
//            Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
//        }
    }
    private fun inputCheck(firstName: String, lastName: String, id: String, phone_number: String, paycheck: Int, age: Int, address: String): Boolean{
        return (firstName.isNotEmpty()) && (lastName.isNotEmpty()) && id.isDigitsOnly() && phone_number.isDigitsOnly() && paycheck.toString().isDigitsOnly() && age.toString().isDigitsOnly() && address.isNotEmpty()
    }

}