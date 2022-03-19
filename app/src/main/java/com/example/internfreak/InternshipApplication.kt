package com.example.internfreak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internfreak.data.data_application_internship
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class InternshipApplication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internship_application)

        val name = "Kishan Patel"
        val email= "k@u.com"
        val mobile="9920019735"
        val location= "NY"
        val education="PHCET"
        val job_internships="HEAD OF PRODUCT DEV"
        val skills = "java"
        val linkcv="https://"

        writedata(name,email,mobile,location,education,job_internships,skills,linkcv)


    }

    private fun writedata(
        name: String,
        email: String,
        mobile: String,
        location: String,
        education: String,
        jobInternships: String,
        skills: String,
        linkcv: String
    ) {
        val database = Firebase.database.reference
        val user_data = data_application_internship(name,email,mobile,location, education,jobInternships,skills,linkcv)
        val data = user_data.toMap()
        val key  = database.push().key
        val userupdates = hashMapOf<String, Any>("Company/Application/${Firebase.auth.uid}/$key/" to data,
            "Users/Application/$key/" to data)
        database.updateChildren(userupdates)
    }
}