package com.example.shtokman.update

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shtokman.R
import com.example.shtokman.model.Workers
import com.example.shtokman.viewmodel.WorkersViewModel
import kotlinx.android.synthetic.main.fragment_workers_add.*
import kotlinx.android.synthetic.main.fragment_workers_update.*
import kotlinx.android.synthetic.main.fragment_workers_update.view.*

class Workers_update: Fragment(R.layout.fragment_workers_update) {

    private val args by navArgs<Workers_updateArgs>()

    private lateinit var mWorkerViewModel: WorkersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mWorkerViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)      //initialize the view model

        view.update_editTextTextPersonName.setText(args.currentWorker.first_name)
        view.update_editTextLastName.setText(args.currentWorker.last_name)
        view.update_add_worker_id.setText(args.currentWorker.id)
        view.update_add_worker_phone_number.setText(args.currentWorker.phone_number)
        view.update_add_worker_paycheck.setText(args.currentWorker.paycheck)
        view.update_add_worker_age.setText(args.currentWorker.age)
        view.update_add_worker_address.setText(args.currentWorker.address)

        update_button_back__workers_save.setOnClickListener {
            updateItem()
        }

        update_delete.setOnClickListener {
            deleteWorker()
        }

        update_button_back.setOnClickListener {
            val action_20 = Workers_updateDirections.actionWorkersUpdateToFacultyPage()
            findNavController().navigate(action_20)
        }

        val view = super.onViewCreated(view, savedInstanceState)

        return view
    }

    private fun updateItem(){
        val first_name = update_editTextTextPersonName.text.toString()
        val last_name = update_editTextLastName.text.toString()
        val id = update_add_worker_id.text.toString()
        val phone_number = update_add_worker_phone_number.text.toString()
        val paycheck = update_add_worker_paycheck.text.toString()
        val age = update_add_worker_age.text.toString()
        val address = update_add_worker_address.text.toString()

//        if (inputCheck(first_name, last_name, id, phone_number, paycheck, age, address)){
        val updatedWorker = Workers(id, first_name, last_name, phone_number, paycheck, age, address)
        mWorkerViewModel.update_worker(updatedWorker)
        Toast.makeText(requireContext(), "Updated successfully", Toast.LENGTH_LONG).show()
        val action_18 = Workers_updateDirections.actionWorkersUpdateToFacultyPage()
        findNavController().navigate(action_18)
//        }
//        else{
//            Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
//        }

    }

    private fun inputCheck(firstName: String, lastName: String, id: String, phone_number: String, paycheck: Int, age: Int, address: String): Boolean{
        return firstName.isNotEmpty() && lastName.isNotEmpty() && id.isDigitsOnly() && phone_number.isDigitsOnly() && paycheck.toString().isDigitsOnly() && age.toString().isDigitsOnly() && address.isNotEmpty()
    }

    private fun deleteWorker(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("כן"){ _, _ ->
            mWorkerViewModel.delete_worker(args.currentWorker)
            Toast.makeText(requireContext(), "Successfullly removed ${args.currentWorker.first_name}", Toast.LENGTH_LONG).show()
            val action_19 = Workers_updateDirections.actionWorkersUpdateToFacultyPage()
            findNavController().navigate(action_19)
        }
        builder.setNegativeButton("לא"){ _, _ -> }
        builder.setTitle("מחק ${args.currentWorker.first_name}")
        builder.setMessage("אתה בטוח שתרצה למחוק את ${args.currentWorker.first_name}?")
        builder.create().show()

    }
}