package com.example.internfreak

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.internfreak.fragment.studentdata
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class StudentDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("user","student").apply()
        val name_student = findViewById<TextInputEditText>(R.id.name_input)
        val address_student = findViewById<TextInputEditText>(R.id.address_input)
        val email_student = findViewById<TextInputEditText>(R.id.email_input)
        val mobile_no_student = findViewById<TextInputEditText>(R.id.mobile_input)
        val Qname_of_college = findViewById<TextInputEditText>(R.id.Qualifications_input1)
        val Qyear_student= findViewById<TextInputEditText>(R.id.Qualifications_input2)
        val QDept_student= findViewById<TextInputEditText>(R.id.Qualifications_input3)
        val skills_student = findViewById<TextInputEditText>(R.id.Skills_input)

        val Submit_button_student = findViewById<ImageButton>(R.id.Submit_student)


        val Gotocompany_text = findViewById<TextView>(R.id.gotocompany_textview)

        Gotocompany_text.setOnClickListener {
            Onlocation()
        }

        Submit_button_student.setOnClickListener {


            updateData(name_student.text.toString(), address_student.text.toString(),email_student.text.toString(),
                mobile_no_student.text.toString(),Qname_of_college.text.toString(),Qyear_student.text.toString(),
                QDept_student.text.toString(),skills_student.text.toString()
            )


        }


    }

    private fun Onlocation(){

        val locationRequest = LocationRequest.create().apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_LOW_POWER
        }

        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
        val client: SettingsClient = LocationServices.getSettingsClient(this)
        val task: Task<LocationSettingsResponse> = client.checkLocationSettings(builder.build())
        task.addOnSuccessListener {
            val intent = Intent(this, CompanyDetails::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            Log.d("MainActivity","task called")
        }

        task.addOnFailureListener { exception ->
            if (exception is ResolvableApiException){
                // Location settings are not satisfied, but this can be fixed
                // by showing the user a dialog.
                try {
                    // Show the dialog by calling startResolutionForResult(),
                    // and check the result in onActivityResult().
                    val REQUEST_CHECK_SETTINGS =1
                    exception.startResolutionForResult(this@StudentDetails,
                        REQUEST_CHECK_SETTINGS)
                } catch (sendEx: IntentSender.SendIntentException) {
                    // Ignore the error.
                }
            }
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
        val studentdata1 = studentdata(name_student,address_student,email_student,mobile_no_student,Qname_of_college,QDept_student,Qyear_student,skills_student)
        val data = studentdata1.toMap()

        val studentdataupdates = hashMapOf<String, Any>("Users/${Firebase.auth.uid}/" to data)
        database.updateChildren(studentdataupdates).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Successfully stored user data to firebase db")
            startActivity(Intent(this, MainActivity::class.java))

        }

    }
}