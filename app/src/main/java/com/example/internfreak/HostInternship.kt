package com.example.internfreak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.internfreak.data.data_application_internship
import com.example.internfreak.data.data_host_internship
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HostInternship : AppCompatActivity() {
    lateinit var long: String
    lateinit var lat:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host_internship)

        val job_role = findViewById<TextInputEditText>(R.id.sjob_role)
        val description = findViewById<TextInputEditText>(R.id.sdescription)
        val company_name = findViewById<TextInputEditText>(R.id.scompany_name_host)
        val openings = findViewById<TextInputEditText>(R.id.sopenings)
        val start_date = findViewById<TextInputEditText>(R.id.sstart_date)
        val duration = findViewById<TextInputEditText>(R.id.sduration)
        val perks = findViewById<TextInputEditText>(R.id.sperks)
        val post_button = findViewById<Button>(R.id.Post_application)
        val stipend = findViewById<TextInputEditText>(R.id.sstipend)

        val database = Firebase.database
        val query1 = database.reference.child("Company/${Firebase.auth.uid}/")
            .orderByChild("location_lat")
        query1.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                     long = snapshot.child("location_long").value.toString()
                     lat = snapshot.child("location_lat").value.toString()

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

        post_button.setOnClickListener {
            writedata(job_role.text.toString(),
                description.text.toString(),
                company_name.text.toString(),
                openings.text.toString(),
                start_date.text.toString(),
                duration.text.toString(),
                perks.text.toString(),
                stipend.text.toString(),
                long,
                lat,
            Firebase.auth.uid.toString())



        }





    }

    private fun writedata(
        job_role: String,
        description: String,
        company_name: String,
        openings: String,
        start_date: String,
        duration: String,
        perks: String,
        stipend :String,
        location_lat:String,
        location_long: String,
        uid: String,

    ) {

        val database = Firebase.database.reference
        val user_data = data_host_internship(job_role,description,company_name,openings,start_date,duration,perks,stipend,
            location_lat,
            location_long,uid)
        val data = user_data.toMap()
        val key  = database.push().key
        val userupdates = hashMapOf<String, Any>("Company/${Firebase.auth.uid}/Internships/$key" to data,
            "Company/Internships/$key" to data)
        database.updateChildren(userupdates)
            .addOnSuccessListener {
                val intent = Intent(this, CompanyProfile::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

    }
}