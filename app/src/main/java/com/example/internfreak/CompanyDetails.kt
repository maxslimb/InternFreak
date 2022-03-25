package com.example.internfreak

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.internfreak.data.datanearby
import com.example.internfreak.fragment.companydata
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import kotlin.properties.Delegates

class CompanyDetails : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var locationlat = 0.0
    private var locationlong = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_details)
        CheckPermission()
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("user","company").apply()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getLastKnownLocation()
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



        Submit_button_company.setOnClickListener {


            updateData(name_company.text.toString(), address_company.text.toString(),email_company.text.toString(),
                mobile_no_company.text.toString(),job_role_company.text.toString(),AboutUs_company.text.toString(),
                locationlat.toString(),locationlong.toString()
            )


        }


    }

    private fun CheckPermission() {
        Dexter.withContext(applicationContext)
            .withPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object : PermissionListener, MultiplePermissionsListener {
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {

                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {

                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    p1: PermissionToken?
                ) {

                }

                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?
                ) {

                }

            })
            .check();
    }



    fun getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(
                this@CompanyDetails,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this@CompanyDetails,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.d("CompanyDetails","permissions prob")
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location->
                if (location != null) {
                    Log.d("CompanyDetails","Location_lat: ${location.latitude}, " +
                            "Location_long: ${location.longitude}")
                    locationlat = location.latitude
                    locationlong= location.longitude
                    val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
                    Toast.makeText(this@CompanyDetails,"Location: $location", Toast.LENGTH_SHORT).show()



                }


            }
            .addOnFailureListener {
                Log.e("CompanyDetails","Location error: ${it.toString()}")
            }

    }

    private fun updateData(
        name_company: String,
        address_company: String,
        email_company: String,
        mobile_no_company: String,
        job_role_company: String,
        AboutUs_company: String,
        locationlat: String,
        locationlong:String

    ) {



        val database = Firebase.database.reference
        val companydata = companydata(name_company,address_company,email_company,mobile_no_company,job_role_company,AboutUs_company,locationlat,locationlong)
        val data = companydata.toMap()

        val editprofileupdates = hashMapOf<String, Any>("Company/${Firebase.auth.uid}/" to data)
        database.updateChildren(editprofileupdates).addOnSuccessListener {
            Log.d(ContentValues.TAG, "Successfully stored user data to firebase db")
            startActivity(Intent(this,CompanyProfile::class.java))

        }
    }


}
