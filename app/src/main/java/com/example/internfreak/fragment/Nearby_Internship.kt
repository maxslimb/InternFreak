package com.example.internfreak.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.internfreak.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class Nearby_Internship : Fragment() {

    private  val ARG_PARAM1 = "param1"
    private  val ARG_PARAM2 = "param2"

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        getLastKnownLocation()



// in onCreate() initialize FusedLocationProviderClient


        /**
         * call this method for receive location
         * get location and give callback when successfully retrieve
         * function itself check location permission before access related methods
         *
         */


        return inflater.inflate(R.layout.fragment_nearby__internship, container, false)
    }
    fun getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireActivity().applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireActivity().applicationContext,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.d("aaaaaaaaaaaa","permissions prob")
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location->
                if (location != null) {
                    Log.d("Maindebud","Location_lat: ${location.latitude}, " +
                            "Location_long: ${location.longitude}")
                    //19.048391 73.071286
                    Toast.makeText(requireView().context,"Location: $location",Toast.LENGTH_SHORT).show()

                    database = Firebase.database
                    val query1 = database.reference.child("Users/")
                        .orderByChild("location_lat")

                    query1.addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(view!!.context,"error: Couldn't find any location",Toast.LENGTH_SHORT).show()
                            Log.w("location", "Couldn't find any location")
                        }

                        override fun onDataChange(snapshot: DataSnapshot) {
                            snapshot.children.forEach {

                                Log.d("location","${it.child("location_lat")}")
                                Toast.makeText(view!!.context,"Found: ${it.value}",Toast.LENGTH_SHORT).show()

                                query1.removeEventListener(this)

                            }

                        }
                    })

                }


            }
            .addOnFailureListener {
                Log.d("Maindebud","Location error: ${it.toString()}")
            }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Nearby_Internship.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Nearby_Internship().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}