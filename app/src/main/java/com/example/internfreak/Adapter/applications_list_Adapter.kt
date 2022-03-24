package com.example.internfreak.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.InternshipApplication
import com.example.internfreak.R
import com.example.internfreak.data.data_application_internship

class applications_list_Adapter(var dataapplications: List<data_application_internship>): RecyclerView.Adapter<applications_list_Adapter.IntViewHolder>() {
    class IntViewHolder(val  row: View) : RecyclerView.ViewHolder(row){
        val imageView = row.findViewById<ImageView>(R.id.userImage)
        val textView1 = row.findViewById<TextView>(R.id.roleapplied)
        val textView2 = row.findViewById<TextView>(R.id.userName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_applicationslist,parent,false)
        val holder= IntViewHolder(layout)
        layout.setOnClickListener {

            val intent = Intent(parent.context, InternshipApplication::class.java)

            intent.putExtra("path","applications_list_Adapter")
            intent.putExtra("name",dataapplications[holder.adapterPosition].name)
            intent.putExtra("email",dataapplications[holder.adapterPosition].email)
            intent.putExtra("mobile",dataapplications[holder.adapterPosition].mobile)
            intent.putExtra("education",dataapplications[holder.adapterPosition].education)
            intent.putExtra("job_internships",dataapplications[holder.adapterPosition].job_internships)
            intent.putExtra("skills",dataapplications[holder.adapterPosition].skills)
            intent.putExtra("Job_Role",dataapplications[holder.adapterPosition].job_role)
            parent.context.startActivity(intent)
        }

        return holder
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        val item=dataapplications[position]


        holder.textView1.text=item.job_role.toString()
        holder.textView2.text=item.name.toString()

    }

    override fun getItemCount(): Int {
        return dataapplications.size
    }
}