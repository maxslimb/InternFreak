package com.example.internfreak.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.MainActivity
import com.example.internfreak.R
import com.example.internfreak.data.company_data
import com.example.internfreak.data.data2

class dashboardAdapter ( var dashboarddata:ArrayList<company_data>) : RecyclerView.Adapter<dashboardAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =dashboarddata[position]
        holder.Comapny_name.text = item.company_name.toString()
        holder.Start_Date.text = item.start_date.toString()
        holder.Duration.text = item.duration.toString()
        holder.Stipend.text = item.stipend.toString()
    }

    override fun getItemCount(): Int {
        return dashboarddata.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview_dashboard,parent,false)
       val  holder  = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context,MainActivity::class.java)
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