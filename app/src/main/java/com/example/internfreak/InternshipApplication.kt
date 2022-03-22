package com.example.internfreak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.internfreak.data.data_application_internship
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class InternshipApplication : AppCompatActivity() {
    lateinit var uid: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internship_application)

        val name = findViewById<TextInputEditText>(R.id.sname)
        val email= findViewById<TextInputEditText>(R.id.semail)
        val mobile=findViewById<TextInputEditText>(R.id.smobile)
        val location= ""
        val education=findViewById<TextInputEditText>(R.id.seducation)
        val job_internships=findViewById<TextInputEditText>(R.id.sjob)
        val skills = findViewById<TextInputEditText>(R.id.sskills)
        val linkcv=findViewById<Button>(R.id.cv)
         uid = intent.getStringExtra("uid")!!

        writedata(name.toString(),email.toString(),mobile.toString(),location.toString(),
            education.toString(),job_internships.toString(),skills.toString(),linkcv.toString())


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
        val userupdates = hashMapOf<String, Any>("Company/Application/${uid}/$key/" to data,
            "Users/Application/${Firebase.auth.uid}/$key/" to data)
        database.updateChildren(userupdates)
    }
}