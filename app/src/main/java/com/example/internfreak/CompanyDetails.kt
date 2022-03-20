package com.example.internfreak

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.internfreak.fragment.companydata
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CompanyDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_details)




        val name_company = findViewById<TextInputEditText>(R.id.name_company)
        val address_company = findViewById<TextInputEditText>(R.id.address_company)
        val email_company = findViewById<TextInputEditText>(R.id.email_company)
        val mobile_no_company = findViewById<TextInputEditText>(R.id.mobile_company)
        val job_role_company = findViewById<TextInputEditText>(R.id.job_role_company)
        val AboutUs_company = findViewById<TextInputEditText>(R.id.AboutUs_company)

        val Submit_button_company = findViewById<Button>(R.id.Submit_company)

        val Gotostudent_text = findViewById<TextView>(R.id.Gotostudent_text)

        Gotostudent_text.setOnClickListener {
            val intent = Intent(this,EditProfile::class.java)
            startActivity(intent)
        }


        val database = Firebase.database.getReference("Users/${Firebase.auth.uid}")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                name_company.setText(snapshot.child("Name").value.toString())
                address_company.setText(snapshot.child("Address").value.toString())
                email_company.setText(snapshot.child("Email").value.toString())
                mobile_no_company.setText(snapshot.child("Mobile No").value.toString())
                job_role_company.setText(snapshot.child("Job Role").value.toString())
                AboutUs_company.setText(snapshot.child("About US").value.toString())
            }


            override fun onCancelled(error: DatabaseError) {
                Log.e(ContentValues.TAG, error.toString())
            }
        })

        Submit_button_company.setOnClickListener {


            updateData(name_company.text.toString(), address_company.text.toString(),email_company.text.toString(),
                mobile_no_company.text.toString(),job_role_company.text.toString(),AboutUs_company.text.toString()
            )


        }


    }

    private fun updateData(
        name_company: String,
        address_company: String,
        email_company: String,
        mobile_no_company: String,
        job_role_company: String,
        AboutUs_company: String
    ) {



        val database = Firebase.database.reference
        val key = database.child("Users/${Firebase.auth.uid}/Profile_Company").push().key
        val companydata = companydata(name_company,address_company,email_company,mobile_no_company,job_role_company,AboutUs_company)
        val data = companydata.toMap()

        val editprofileupdates = hashMapOf<String, Any>("Users/${Firebase.auth.uid}/Profile_Company/$key" to data)
        database.updateChildren(editprofileupdates).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Successfully stored user data to firebase db")
            startActivity(Intent(this, MainActivity::class.java))

        }
    }


}
