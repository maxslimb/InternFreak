package com.example.internfreak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
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
        val education=findViewById<TextInputEditText>(R.id.seducation)
        val job_internships=findViewById<TextInputEditText>(R.id.sjob)
        val skills = findViewById<TextInputEditText>(R.id.sskills)
        val linkcv=findViewById<Button>(R.id.cv)
        val job_role = intent.getStringExtra("Job_Role")
        val path = intent.getStringExtra("path")
        val submit_button = findViewById<ImageButton>(R.id.Submit_application)
        val apply_button = findViewById<ImageButton>(R.id.apply_application_btn)

        if(path == "applications_list_Adapter")
        {
            submit_button.visibility = View.GONE
            apply_button.visibility = View.VISIBLE
        }
        if(path== "InternshipDetails")
        {
            submit_button.visibility = View.VISIBLE
            apply_button.visibility = View.GONE
        }

         uid = intent.getStringExtra("uid")!!

        val submit_application_button = findViewById<ImageButton>(R.id.Submit_application)
        submit_application_button.setOnClickListener {
            writedata(
                name.text.toString(), email.text.toString(), mobile.text.toString(),
                education.text.toString(), job_internships.text.toString(), skills.text.toString(),job_role.toString(),
                linkcv.text.toString()
            )
        }


    }

    private fun writedata(
        name: String,
        email: String,
        mobile: String,
        education: String,
        jobInternships: String,
        skills: String,
        job_role: String,
        linkcv: String
    ) {
        val database = Firebase.database.reference
        val user_data = data_application_internship(name,email,mobile, education,jobInternships,skills,job_role,linkcv)
        val data = user_data.toMap()
        val key  = database.push().key
        val userupdates = hashMapOf<String, Any>("Company/Applications/${Firebase.auth.uid}/$key/" to data,
            "Users/${Firebase.auth.uid}/Applications//$key/" to data)
        database.updateChildren(userupdates)
    }
}