package com.example.internfreak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CompanyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_profile)

        val application=findViewById<ImageButton>(R.id.btn_applications)
        val button_host_app = findViewById<ImageButton>(R.id.btn_host_internships)
        button_host_app.setOnClickListener {
            startActivity(Intent(this, HostInternship::class.java))
        }
        application.setOnClickListener{
            startActivity(Intent(this, Applications_list::class.java))
        }

        val signout = findViewById<ImageButton>(R.id.btn_signout)
        signout.setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(this, SignInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or (Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

    }
}