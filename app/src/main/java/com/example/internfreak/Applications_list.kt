package com.example.internfreak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.Adapter.applications_list_Adapter
import com.example.internfreak.data.data_application_internship
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class Applications_list : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applications)

        val data1= arrayListOf<data_application_internship>()
        val recycler = findViewById<RecyclerView>(R.id.applications_rv)
        recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        recycler.adapter = applications_list_Adapter(data1)
        database = FirebaseDatabase.getInstance().getReference("Company/Applications/${Firebase.auth.uid}/")

        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
               Log.e("Applications_list",p0.toString())
            }

            override fun onDataChange(p0: DataSnapshot) {
                p0.children.forEach { it ->
                    val application_data = it.getValue<data_application_internship>()
                    application_data?.let { data1.add(it) }
                    recycler!!.adapter!!.notifyDataSetChanged()
                }
            }
        })


    }
}
