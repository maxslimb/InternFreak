package com.example.internfreak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.R
import com.example.internfreak.data.data1

class Connect_Adapter(var data: List<data1>):RecyclerView.Adapter<Connect_Adapter.IntViewHolder>(){
    class IntViewHolder(val  row: View) : RecyclerView.ViewHolder(row) {
        val imageView = row.findViewById<ImageView>(R.id.itemImage)
        val textView1 = row.findViewById<TextView>(R.id.itemType)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_connect,parent,false)
        val holder= IntViewHolder(layout)
        return holder    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        val item=data[position]

        holder.imageView.setBackgroundResource(item.company_image)
        holder.textView1.text=item.company_name.toString()
    }

    override fun getItemCount(): Int {
        return data.size    }
}