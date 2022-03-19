package com.example.internfreak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.internfreak.fragment.Connect
import com.example.internfreak.fragment.Dashboard
import com.example.internfreak.fragment.Nearby_Internship
import com.example.internfreak.fragment.Profile
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val dashboard= Dashboard()
    private val connect= Connect()
    private val nearbyInternship= Nearby_Internship()
    private val profile= Profile()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottom_navigation=findViewById<BottomNavigationView>(R.id.bottom_navigation)


        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.page_1 ->replaceFragment(dashboard)
                R.id.page_2 ->replaceFragment(connect)
                R.id.page_3 ->replaceFragment(nearbyInternship)
                R.id.page_4 ->replaceFragment(profile)
            }
            true
        }





        replaceFragment(dashboard)
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }

    }
}