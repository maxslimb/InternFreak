package com.example.internfreak.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.internfreak.R
import com.example.internfreak.data.datanearby

class NearbyAdapter(var data: List<datanearby>): RecyclerView.Adapter<NearbyAdapter.IntViewHolder>() {
    lateinit var context : Context
    class IntViewHolder(val  row: View) : RecyclerView.ViewHolder(row) {
        val imageView = row.findViewById<ImageView>(R.id.itemImage)
        val textView1 = row.findViewById<TextView>(R.id.itemType)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_connect,parent,false)
        context = parent.context
        val holder= IntViewHolder(layout)
        return holder    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        val item=data[position]

        Glide.with(context).load(item.company_image).into(holder.imageView)
        holder.textView1.text=item.company_name.toString()
    }

    override fun getItemCount(): Int {
        return data.size    }
}