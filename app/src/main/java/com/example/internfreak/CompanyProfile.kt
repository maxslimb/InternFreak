package com.example.internfreak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CompanyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_profile)

        val application=findViewById<Button>(R.id.btn_applications)
        application.setOnClickListener{
            startActivity(Intent(this, Applications_list::class.java))


        }

        val signout = findViewById<Button>(R.id.btn_signout)
        signout.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this, SignInActivity::class.java))

        }

    }
}