package com.example.internfreak.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.internfreak.R


class Profile : Fragment() {

/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding= FragmentProfileBinding.inflate(layoutInflater)
        binding.btn_edit_profile.setOnClickListener{
            val intent=Intent(this@Profile.requireContext(),EditProfile::class.java)
            startActivity(intent)

        }


    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       /* val binding= FragmentProfileBinding.inflate(layoutInflater)
        binding.btn_edit_profile.setOnClickListener{
            val intent=Intent(this@Profile.requireContext(),EditProfile::class.java)
            startActivity(intent)

        }*/
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


}