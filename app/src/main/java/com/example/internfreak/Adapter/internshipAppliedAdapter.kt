package com.example.internfreak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.R
import com.example.internfreak.data.company_data
import com.example.internfreak.data.intern_applied_data
import com.example.internfreak.fragment.dashboardAdapter

class internshipAppliedAdapter (var internapplieddata: ArrayList<intern_applied_data>)  : RecyclerView.Adapter<internshipAppliedAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): internshipAppliedAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview_application_applied, parent, false)
        val holder = internshipAppliedAdapter.ViewHolder(view)

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val  Name_of_Company_applicant: TextView = itemView.findViewById(R.id.Name_of_Company_applicant)
        val status_applicant: TextView = itemView.findViewById(R.id.status_applicant)
        val Job_Role_applicant: TextView = itemView.findViewById(R.id.Job_role_applicant)

    }

    override fun onBindViewHolder(holder: internshipAppliedAdapter.ViewHolder, position: Int) {
        val item =internapplieddata[position]
        holder.Name_of_Company_applicant.text = item.Name_applicant.toString()
        holder.status_applicant.text = item.status.toString()


    }

    override fun getItemCount(): Int {
        return internapplieddata.size
    }
}