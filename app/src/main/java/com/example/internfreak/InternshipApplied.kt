package com.example.internfreak

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.Adapter.internshipAppliedAdapter
import com.example.internfreak.data.company_data
import com.example.internfreak.data.data_application_internship
import com.example.internfreak.fragment.dashboardAdapter
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class InternshipApplied : AppCompatActivity() {

    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internship_applied)


        database = FirebaseDatabase.getInstance().getReference("User/${Firebase.auth.uid}/Applications")
        val applicationdata = arrayListOf<data_application_internship>()

        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (i in p0.children) {

                    val applicationdat = i.getValue<data_application_internship>()

                    applicationdat?.let { applicationdata.add(it) }
                    Log.e(ContentValues.TAG,"user info" +applicationdat)


                }
                val recycler =findViewById<RecyclerView>(R.id.internships_applied_rv)

                recycler.layoutManager = LinearLayoutManager(this@InternshipApplied, LinearLayoutManager.VERTICAL, true)
                recycler.adapter = internshipAppliedAdapter(applicationdata)

            }
        })





    }
}