package com.example.internfreak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class EditProfile : AppCompatActivity() {

    val TAG = "Profile Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)


    /*    val ed_name_student = findViewById<TextInputEditText>(R.id.ed_name_input)
        val ed_address_student = findViewById<TextInputEditText>(R.id.ed_address_input)
        val ed_email_student = findViewById<TextInputEditText>(R.id.ed_email_input)
        val ed_mobile_no_student = findViewById<TextInputEditText>(R.id.ed_mobile_input)
        val ed_Qname_of_college = findViewById<TextInputEditText>(R.id.ed_Qualifications_input1)
        val ed_Qyear_student= findViewById<TextInputEditText>(R.id.ed_Qualifications_input2)
        val ed_QDept_student= findViewById<TextInputEditText>(R.id.ed_Qualifications_input3)
        val ed_skills_student = findViewById<TextInputEditText>(R.id.ed_Skills_input)

        val Save_student = findViewById<Button>(R.id.Save_student)



        val current_user=intent.getBooleanExtra("current-user",false)

        val database = Firebase.database.getReference("Users/${Firebase.auth.uid}")

        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                ed_name_student.setText(snapshot.child("name_input").value.toString())
                ed_address_student.setText(snapshot.child("address_input").value.toString())
                ed_email_student.setText(snapshot.child("name_input").value.toString())
                ed_mobile_no_student.setText(snapshot.child("name_input").value.toString())
                ed_Qname_of_college.setText(snapshot.child("name_input").value.toString())
                ed_Qyear_student.setText(snapshot.child("name_input").value.toString())
                ed_QDept_student.setText(snapshot.child("name_input").value.toString())
                ed_skills_student.setText(snapshot.child("name_input").value.toString())


                Log.d(TAG,snapshot.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, error.toString())
            }

        })

        Save_student.setOnClickListener {

            updateData(ed_name_student.text.toString(), ed_address_student.text.toString(),ed_email_student.text.toString(),ed_mobile_no_student.text.toString(),ed_address_student.text.toString(),)
        }
    }

    private fun updateData(name: String, email: String) {

        val database = Firebase.database.reference

        val user_data = userdata(name,email)
        val data = user_data.toMap()
        val userupdates = hashMapOf<String, Any>("Users/${Firebase.auth.uid}/" to data)
        database.updateChildren(userupdates).addOnSuccessListener {
            Log.d(TAG,"Successfully stored user data to firebase db")
            startActivity(Intent(this, MainActivity::class.java))

        }
    }*/

}}


