package com.example.internfreak

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.internfreak.data.data_application_internship
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class InternshipApplication : AppCompatActivity() {
    lateinit var uid: String
    private lateinit var database: FirebaseDatabase
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
        val submit_button = findViewById<ImageButton>(R.id.Submit_application)
        val apply_button = findViewById<ImageButton>(R.id.apply_application_btn)
        val job_role = intent.getStringExtra("Job_Role")
        val path = intent.getStringExtra("path")
        val company_name = intent.getStringExtra("Company_Name")
        val Name = intent.getStringExtra("name")
        val Email = intent.getStringExtra("email")
        val Mobile = intent.getStringExtra("mobile")
        val Education = intent.getStringExtra("education")
        val Job_internships = intent.getStringExtra("job_internships")
        val Skills= intent.getStringExtra("skills")
        val uid_student = intent.getStringExtra("uid_student")
        name.setText(Name)
        email.setText(Email)
        mobile.setText(Mobile)
        education.setText(Education)
        job_internships.setText(Job_internships)
        skills.setText(Skills)




        if(path == "applications_list_Adapter")
        {
            submit_button.visibility = View.GONE
            apply_button.visibility = View.VISIBLE
        }
        if(path== "InternshipDetails")
        {
            uid = intent?.getStringExtra("uid").toString()
            submit_button.visibility = View.VISIBLE
            apply_button.visibility = View.GONE
        }



        apply_button.setOnClickListener {



            database = Firebase.database
            val query1 = database.reference.child("Users/FFM0wBfQF0fGIJQK3Z8IGSV7Oyj2/Applications/")  //Users/$uid_student/Applications/
                .orderByChild("Name")

            query1.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@InternshipApplication,"error: Couldn't find any location", Toast.LENGTH_SHORT).show()
                    Log.w("location", "Couldn't find any location")
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onDataChange(snapshot: DataSnapshot) {

                    snapshot.children.forEach {
                        Log.d("RzLXs3nMzscUDDRXU7Aav9zoL5T2","${it.value}")
                       if ((it.child("company_name").value==company_name)&&(it.child("job_role").value==job_role)){
                           database.reference.child("Users/FFM0wBfQF0fGIJQK3Z8IGSV7Oyj2/Applications/${it.key}/Status").setValue("Approved")
                           query1.removeEventListener(this)
                           Toast.makeText(this@InternshipApplication,"Approved Successfully",Toast.LENGTH_SHORT).show()
                           val intent = Intent(this@InternshipApplication, CompanyProfile::class.java)
                           intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                           startActivity(intent)
                       }
                        query1.removeEventListener(this)
                    }
                }
            })
        }

        submit_button.setOnClickListener {
            writedata(
                name.text.toString(), email.text.toString(), mobile.text.toString(),
                education.text.toString(), job_internships.text.toString(), skills.text.toString(),job_role.toString(),
                linkcv.text.toString(),company_name!!
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
        linkcv: String,
        company_name: String
    ) {
        val database = Firebase.database.reference
        val user_data = data_application_internship(name,email,mobile, education,jobInternships,skills,job_role,linkcv,Firebase.auth.uid,company_name)
        val data = user_data.toMap()
        val key  = database.push().key
        val userupdates = hashMapOf<String, Any>("Company/Applications/${uid}/$key/" to data,
            "Users/${Firebase.auth.uid}/Applications//$key/" to data)
        database.updateChildren(userupdates).addOnSuccessListener {
            Toast.makeText(this,"Applied Successfully",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}