package com.example.shtokman.worker_page_fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shtokman.R
import com.example.shtokman.viewmodel.WorkersViewModel
import kotlinx.android.synthetic.main.fragment_filter.*
import kotlinx.android.synthetic.main.fragment_filter.view.*
import kotlinx.android.synthetic.main.fragment_workers_appearences.*


class filter_appearences: DialogFragment() {

    private lateinit var mWorkerViewModel: WorkersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mWorkerViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)
        val rootView: View = inflater.inflate(R.layout.fragment_filter, container, false)

        mWorkerViewModel.readAllBoth.observe(viewLifecycleOwner, Observer { work_appear ->
            val lst: MutableList<String> = mutableListOf<String>()
            lst.add("כולם")
            for (wor in work_appear)
            {
                lst.add(wor.worker.first_name)
            }
            val my_array: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), R.layout.simple_spinner_item, lst)
            my_array.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            filter_spinner.adapter = my_array

        })
        rootView.filter_cancel.setOnClickListener {
            val action = filter_appearencesDirections.actionFilterAppearencesToWorkersAppearences()
            findNavController().navigate(action)
        }
        rootView.filter_confirm.setOnClickListener {
            val answer = filter_spinner.selectedItem.toString()
            var day = date_picker_filter.dayOfMonth
            var month = date_picker_filter.month + 1
            var year = date_picker_filter.year
            if (all_times.isChecked){
                day = 0
                month = 0
                year = 0
            }
//            val date : String = date_picker_filter.dayOfMonth.toString() + "/" + (date_picker_filter.month + 1).toString() + "/" + date_picker_filter.year.toString()
            val action = filter_appearencesDirections.actionFilterAppearencesToWorkersAppearences(answer, day, month, year)
            findNavController().navigate(action)
        }
//        rootView.select_date.setOnClickListener {
//            val action2 = filter_appearencesDirections.actionFilterAppearencesToDatePicker()
//            findNavController().navigate(action2)
//        }
        return rootView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dia = super.onCreateDialog(savedInstanceState)
        dia.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return dia
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(900,1300)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        if (args.stringOfDate != "Date"){
//            select_date.setText(args.stringOfDate)
//        }
//        else{
//            select_date.setText("DATE")
//        }
//    }
}