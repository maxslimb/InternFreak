package com.example.internfreak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internfreak.data.data_application_internship
import com.example.internfreak.data.data_host_internship
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HostInternship : AppCompatActivity() {
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


        writedata(job_role.text.toString(),
            description.text.toString(),
            company_name.text.toString(),
            openings.text.toString(),
            start_date.text.toString(),
            duration.text.toString(),
            perks.text.toString())




    }

    private fun writedata(
        job_role: String,
        description: String,
        company_name: String,
        openings: String,
        start_date: String,
        duration: String,
        perks: String,

    ) {

        val database = Firebase.database.reference
        val user_data = data_host_internship(job_role,description,company_name,openings,start_date,duration,perks)
        val data = user_data.toMap()
        val key  = database.push().key
        val userupdates = hashMapOf<String, Any>("Company/${Firebase.auth.uid}/Internships" to data,
            "Company/Internships" to data)
        database.updateChildren(userupdates)

    }
}