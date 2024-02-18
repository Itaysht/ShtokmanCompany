package com.example.shtokman.worker_page_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shtokman.R
import com.example.shtokman.model.AppearWithWorkers
import com.example.shtokman.viewmodel.WorkersViewModel
import kotlinx.android.synthetic.main.fragment_filter.*
import kotlinx.android.synthetic.main.fragment_workers_appearences.*

class Workers_appearences : Fragment(R.layout.fragment_workers_appearences) {
    private lateinit var mWorkerViewModel: WorkersViewModel
    private val args by navArgs<Workers_appearencesArgs>()
    private var ans_id : String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mWorkerViewModel = ViewModelProvider(this).get(WorkersViewModel::class.java)
        appear_deleteAll.setOnClickListener {
            mWorkerViewModel.delete_all_appear()
            Toast.makeText(requireContext(), "הכל נמחק", Toast.LENGTH_SHORT).show()
        }
        val str = args.day.toString() + "." + args.month.toString() + "." + args.year.toString()
        if (args.day != 0) {
            temp.setText(str)
        }
        filter.setOnClickListener {
            val action = Workers_appearencesDirections.actionWorkersAppearencesToFilterAppearences()
            findNavController().navigate(action)
        }
        if (args.name == "כולם") {
            mWorkerViewModel.readAllBoth.observe(viewLifecycleOwner, Observer { work_appear ->
                fill_Table(work_appear)
            })
        }
        else {
            mWorkerViewModel.readAllBoth.observe(viewLifecycleOwner, Observer { work_appear ->
                for (wrk in work_appear) {
                    if (args.name == wrk.worker.first_name) {
                        this.ans_id = wrk.worker.id.toString()
                    }
                }
                mWorkerViewModel.setFilter(this.ans_id)
                mWorkerViewModel.wrkFilters.observe(viewLifecycleOwner, Observer {wrk ->
                    fill_Table(wrk)
                })
            })
        }
        appear_back.setOnClickListener {
            val action_24 = Workers_appearencesDirections.actionWorkersAppearencesToWorkersPage()
            findNavController().navigate(action_24)
        }
    }

    fun initi(): MutableList<TextView>{
        val lst_tv: MutableList<TextView> = mutableListOf()
        for (temp in 0..8){
            lst_tv.add(TextView(requireContext()))
            lst_tv[temp].width = column_first_name[temp].width
            lst_tv[temp].height = column_first_name[temp].height
            lst_tv[temp].textAlignment = View.TEXT_ALIGNMENT_TEXT_END
            lst_tv[temp].setPadding(20,0,0,0)
        }
        lst_tv[0].textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        lst_tv[0].setPadding(0,0,40,0)
        lst_tv[1].textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        return lst_tv
    }
    fun fill_Table(wrk:List<AppearWithWorkers>){
        val tb = table_of_appear
        for (i in wrk){
            var lst_tv: MutableList<TextView> = initi()
            val lst_of_i = i.appears
            for (j in lst_of_i) {
                if (((j.day != args.day)||(j.month != args.month)||(j.year != args.year))&&(args.day != 0)){
                    continue
                }
                val tv = TableRow(requireContext())
                lst_tv[0].setText(i.worker.first_name)
                lst_tv[1].setText(i.worker.last_name)
                lst_tv[2].setText(j.today_hours)
                lst_tv[3].setText(j.comeIn)
                lst_tv[4].setText(j.comeOut)
                lst_tv[5].setText(j.day.toString())
                lst_tv[6].setText(j.month.toString())
                lst_tv[7].setText(j.creatorID)
                lst_tv[8].setText(j.year.toString())
                for (k in 0..8) {
                    tv.addView(lst_tv[k])
                }
                tb.addView(tv)
                lst_tv = initi()
            }
        }

    }
}