package com.example.internfreak.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.InternshipApplication
import com.example.internfreak.InternshipDetails
import com.example.internfreak.MainActivity
import com.example.internfreak.R
import com.example.internfreak.data.company_data
import com.example.internfreak.data.data2
import com.example.internfreak.data.data_host_internship

class dashboardAdapter(var dashboarddata: ArrayList<company_data>) : RecyclerView.Adapter<dashboardAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =dashboarddata[position]
        holder.Comapny_name.text = item.Company_Name.toString()
        holder.Start_Date.text = item.Start_Date.toString()
        holder.Duration.text = item.Duration.toString()
        holder.Stipend.text = item.Stipend.toString()
    }

    override fun getItemCount(): Int {
        return dashboarddata.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview_dashboard,parent,false)
       val  holder  = ViewHolder(view)
        view.setOnClickListener {

            val intent = Intent(parent.context,InternshipDetails::class.java)
            intent.putExtra("Job_Role",dashboarddata[holder.adapterPosition].Job_Role)
            intent.putExtra("Description",dashboarddata[holder.adapterPosition].Description)
            intent.putExtra("Company_Name",dashboarddata[holder.adapterPosition].Company_Name)
            intent.putExtra("Openings",dashboarddata[holder.adapterPosition].Openings)
            intent.putExtra("Start_Date",dashboarddata[holder.adapterPosition].Start_Date)
            intent.putExtra("Duration",dashboarddata[holder.adapterPosition].Duration)
            intent.putExtra("Perks",dashboarddata[holder.adapterPosition].Perks)
            intent.putExtra("Stipend",dashboarddata[holder.adapterPosition].Stipend)
            intent.putExtra("Location_lat",dashboarddata[holder.adapterPosition].location_lat)
            intent.putExtra("Location_long",dashboarddata[holder.adapterPosition].location_long)
            intent.putExtra("uid",dashboarddata[holder.adapterPosition].uid)
            parent.context.startActivity(intent)

        }

        return holder
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val Comapny_name : TextView = itemView.findViewById(R.id.company_name_output)
        val Start_Date: TextView = itemView.findViewById(R.id.Start_date_output)
        val Duration: TextView = itemView.findViewById(R.id.Duration_output)
        val Stipend: TextView = itemView.findViewById(R.id.stipend_output)

    }


}