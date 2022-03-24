package com.example.internfreak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.R
import com.example.internfreak.data.data_application_internship

class internshipAppliedAdapter (var internapplieddata: ArrayList<data_application_internship>)  : RecyclerView.Adapter<internshipAppliedAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): internshipAppliedAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview_application_applied, parent, false)
        val holder = internshipAppliedAdapter.ViewHolder(view)
        return holder

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val  Name_of_Company_applicant: TextView = itemView.findViewById(R.id.Name_of_Company_applicant)
        val status_applicant: TextView = itemView.findViewById(R.id.status_applicant)
        val Job_Role_applicant: TextView = itemView.findViewById(R.id.Job_role_applicant)

    }

    override fun onBindViewHolder(holder: internshipAppliedAdapter.ViewHolder, position: Int) {
        val item =internapplieddata[position]
        holder.Job_Role_applicant.text=item.job_role
        holder.Name_of_Company_applicant.text = item.company_name.toString()
        holder.status_applicant.text = item.Status.toString()

    }

    override fun getItemCount(): Int {
        return internapplieddata.size
    }
}