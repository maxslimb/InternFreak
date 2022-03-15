package com.example.internfreak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val google_signin_btn =findViewById<com.google.android.gms.common.SignInButton>(R.id.google_sign_in)

        google_signin_btn.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }
}