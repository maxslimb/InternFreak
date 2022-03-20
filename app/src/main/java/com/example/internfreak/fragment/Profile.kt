package com.example.internfreak.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.internfreak.R
import com.example.internfreak.SignInActivity
import com.example.internfreak.databinding.FragmentProfileBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Profile : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentProfileBinding.inflate(layoutInflater)

       /* val binding= FragmentProfileBinding.inflate(layoutInflater)
        binding.btn_edit_profile.setOnClickListener{
            val intent=Intent(this@Profile.requireContext(),EditProfile::class.java)
            startActivity(intent)

        }*/


        return inflater.inflate(R.layout.fragment_profile, container, false)
    }



}