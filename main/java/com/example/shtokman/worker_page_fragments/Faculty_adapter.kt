package com.example.shtokman.worker_page_fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.shtokman.R
import com.example.shtokman.model.Workers
import kotlinx.android.synthetic.main.custom_raw.view.*

class Faculty_adapter: RecyclerView.Adapter<Faculty_adapter.MyViewHolder>() {

    private var workerList = emptyList<Workers>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_raw, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = workerList[position]
        holder.itemView.custom_text_2.text = currentItem.first_name
        holder.itemView.custom_text_3.text = currentItem.last_name
        holder.itemView.custom_text_1.text = currentItem.id
        holder.itemView.custom_text_4.text = currentItem.phone_number

        holder.itemView.custom_raw.setOnClickListener {
            val action_17 = Faculty_pageDirections.actionFacultyPageToWorkersUpdate(currentItem)
            holder.itemView.findNavController().navigate(action_17)
        }

    }

    override fun getItemCount(): Int {
        return workerList.size
    }

    fun setData(worker: List<Workers>){
        this.workerList = worker
        notifyDataSetChanged()
    }

}