package com.example.internfreak.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.InternshipDetails
import com.example.internfreak.R
import com.example.internfreak.data.company_data

class ItemAdapter:  RecyclerView.Adapter<ItemAdapter.ItemAdapterVH>(), Filterable {

    var itemModalList = ArrayList<company_data>()
    var itemModalListFilter = ArrayList<company_data>()

    fun setData(itemModalList: ArrayList<company_data>){
        this.itemModalListFilter = itemModalList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemAdapterVH {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.itemview_dashboard, parent, false)
        val holder = ItemAdapterVH(view)
        view.setOnClickListener {

            val intent = Intent(parent.context, InternshipDetails::class.java)
            intent.putExtra("Job_Role",itemModalList[holder.adapterPosition].Job_Role)
            intent.putExtra("Description",itemModalList[holder.adapterPosition].Description)
            intent.putExtra("Company_Name",itemModalList[holder.adapterPosition].Company_Name)
            intent.putExtra("Openings",itemModalList[holder.adapterPosition].Openings)
            intent.putExtra("Start_Date",itemModalList[holder.adapterPosition].Start_Date)
            intent.putExtra("Duration",itemModalList[holder.adapterPosition].Duration)
            intent.putExtra("Perks",itemModalList[holder.adapterPosition].Perks)
            intent.putExtra("Stipend",itemModalList[holder.adapterPosition].Stipend)
            intent.putExtra("Location_lat",itemModalList[holder.adapterPosition].location_lat)
            intent.putExtra("Location_long",itemModalList[holder.adapterPosition].location_long)
            intent.putExtra("uid",itemModalList[holder.adapterPosition].uid)
            parent.context.startActivity(intent)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemAdapterVH, position: Int) {
        val item =itemModalList[position]
        holder.Comapny_name.text = item.Company_Name.toString()
        holder.Start_Date.text = item.Start_Date.toString()
        holder.Duration.text = item.Duration.toString()
        holder.Stipend.text = item.Stipend.toString()
    }

    override fun getItemCount(): Int {
        return itemModalList.size
    }
    class ItemAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Comapny_name : TextView = itemView.findViewById(R.id.company_name_output)
        val Start_Date: TextView = itemView.findViewById(R.id.Start_date_output)
        val Duration: TextView = itemView.findViewById(R.id.Duration_output)
        val Stipend: TextView = itemView.findViewById(R.id.stipend_output)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults? {
                val filterResults = FilterResults()
                if(p0 == null || p0.length < 0){
                    filterResults.count = itemModalListFilter.size
                    filterResults.values = itemModalListFilter
                }
                else{
                    val searchr = p0.toString()

                    val itemModal = ArrayList<company_data>()


                    for(items in itemModalListFilter){

                        if(items.Company_Name.contains(searchr) || items.Job_Role.contains(searchr)){
                            itemModal.add(items)
                        }
                    }
                    filterResults.count = itemModal.size
                    filterResults.values = itemModal
                }

                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                itemModalList = p1!!.values as ArrayList<company_data>
                notifyDataSetChanged()
            }

        }
    }

}