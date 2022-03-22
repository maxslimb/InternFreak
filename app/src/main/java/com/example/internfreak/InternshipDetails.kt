package com.example.internfreak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InternshipDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internship_details)
        val submit_button = findViewById<Button>(R.id.submit_button_internship)
        val uid = intent.getStringExtra("uid")
        submit_button.setOnClickListener {
            val intent = Intent(this,InternshipApplication::class.java)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }
    }
}