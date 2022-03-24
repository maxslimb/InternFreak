package com.example.internfreak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class InternshipDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internship_details)
        val submit_button = findViewById<Button>(R.id.apply_button_internship_details)
        val uid = intent.getStringExtra("uid")
        val Job_Role = intent.getStringExtra("Job_Role")
        val Description = intent.getStringExtra("Description")
        val Company_Name = intent.getStringExtra("Company_Name")
        val Openings = intent.getStringExtra("Openings")
        val Start_Date = intent.getStringExtra("Start_Date")
        val Duration= intent.getStringExtra("Duration")
        val Perks = intent.getStringExtra("Perks")
        val Stipend = intent.getStringExtra("Stipend")
        val location_lat = intent.getStringExtra("Location_lat")
        val location_long = intent.getStringExtra("Location_long")

        val company_name_tv = findViewById<TextView>(R.id.textView8)
        company_name_tv.setText(Company_Name)
        val start_date_tv = findViewById<TextView>(R.id.textView10)
        start_date_tv.setText(Start_Date)
        val duration_tv = findViewById<TextView>(R.id.textView11)
        duration_tv.setText(Duration)
        val stipend_tv = findViewById<TextView>(R.id.stipend_tv)
        stipend_tv.setText(Stipend)
        val about_tv = findViewById<TextView>(R.id.textView12)
        about_tv.setText(Description)
        val perks_tv = findViewById<TextView>(R.id.perks_certi)
        perks_tv.setText(Perks)
        val no_of_openings = findViewById<TextView>(R.id.number_of_openings)
        no_of_openings.setText(Openings)




        submit_button.setOnClickListener {
            val intent = Intent(this,InternshipApplication::class.java)
            intent.putExtra("uid",uid)

            intent.putExtra("Job_Role",Job_Role)
            intent.putExtra("Description",Description)
            intent.putExtra("Company_Name",Company_Name)
            intent.putExtra("Openings",Openings)
            intent.putExtra("Start_Date",Start_Date)
            intent.putExtra("Duration",Duration)
            intent.putExtra("Perks",Perks)
            intent.putExtra("Stipend",Stipend)
            intent.putExtra("Location_lat",location_lat)
            intent.putExtra("Location_long",location_long)

            startActivity(intent)






        }
    }
}