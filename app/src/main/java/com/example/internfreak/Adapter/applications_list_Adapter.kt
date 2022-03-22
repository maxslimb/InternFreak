package com.example.internfreak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.R
import com.example.internfreak.data.data1
import com.example.internfreak.data.data_application_internship
import com.example.internfreak.data.dataapplications

class applications_list_Adapter(var dataapplications: List<data_application_internship>): RecyclerView.Adapter<applications_list_Adapter.IntViewHolder>() {
    class IntViewHolder(val  row: View) : RecyclerView.ViewHolder(row){
        val imageView = row.findViewById<ImageView>(R.id.userImage)
        val textView1 = row.findViewById<TextView>(R.id.roleapplied)
        val textView2 = row.findViewById<TextView>(R.id.userName)
        val textView3 = row.findViewById<TextView>(R.id.user_location)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_applicationslist,parent,false)
        val holder= IntViewHolder(layout)
        return holder
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        val item=dataapplications[position]


        holder.textView1.text=item.jobrole.toString()
        holder.textView2.text=item.name.toString()

    }

    override fun getItemCount(): Int {
        return dataapplications.size
    }
}