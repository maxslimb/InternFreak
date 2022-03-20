package com.example.internfreak

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.internfreak.fragment.editprofiledata
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)



        val name_student = findViewById<TextInputEditText>(R.id.name_input)
        val address_student = findViewById<TextInputEditText>(R.id.address_input)
        val email_student = findViewById<TextInputEditText>(R.id.email_input)
        val mobile_no_student = findViewById<TextInputEditText>(R.id.mobile_input)
        val Qname_of_college = findViewById<TextInputEditText>(R.id.Qualifications_input1)
        val Qyear_student= findViewById<TextInputEditText>(R.id.Qualifications_input2)
        val QDept_student= findViewById<TextInputEditText>(R.id.Qualifications_input3)
        val skills_student = findViewById<TextInputEditText>(R.id.Skills_input)

        val Submit_button_student = findViewById<Button>(R.id.Submit_student)
        val Gotocompany_text = findViewById<TextView>(R.id.gotocompany_textview)

        Gotocompany_text.setOnClickListener {
            val intent = Intent(this,CompanyDetails::class.java)
            startActivity(intent)
        }

        val database = Firebase.database.getReference("Users/${Firebase.auth.uid}")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                name_student.setText(snapshot.child("Name").value.toString())
                address_student.setText(snapshot.child("Address").value.toString())
                email_student.setText(snapshot.child("Email").value.toString())
                mobile_no_student.setText(snapshot.child("Mobile No").value.toString())
                Qname_of_college.setText(snapshot.child("College Name").value.toString())
                Qyear_student.setText(snapshot.child("Current Year").value.toString())
                QDept_student.setText(snapshot.child("Department").value.toString())
                skills_student.setText(snapshot.child("Skills").value.toString())


            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(ContentValues.TAG, error.toString())
            }
        })

        Submit_button_student.setOnClickListener {


            updateData(name_student.text.toString(), address_student.text.toString(),email_student.text.toString(),
                    mobile_no_student.text.toString(),Qname_of_college.text.toString(),Qyear_student.text.toString(),
               QDept_student.text.toString(),skills_student.text.toString()
            )


        }


    }

    private fun updateData(
        name_student: String,
        address_student: String,
        email_student: String,
        mobile_no_student: String,
        Qname_of_college: String,
        Qyear_student: String,
        QDept_student: String,
        skills_student: String
    ) {


        val database = Firebase.database.reference
        val editprofiledata = editprofiledata(name_student,address_student,email_student,mobile_no_student,Qname_of_college,QDept_student,Qyear_student,skills_student)
        val data = editprofiledata.toMap()

        val editprofileupdates = hashMapOf<String, Any>("Users/${Firebase.auth.uid}/Profile_Student" to data)
        database.updateChildren(editprofileupdates).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Successfully stored user data to firebase db")
            startActivity(Intent(this, MainActivity::class.java))

    }


}
}