package com.example.internfreak.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.internfreak.EditProfile
import com.example.internfreak.R


class Profile : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn_rdit_profile= view.findViewById<Button>(R.id.btn_edit_profile)
        btn_rdit_profile.setOnClickListener{
            val intent= Intent(view.context, EditProfile::class.java)
            startActivity(intent)
        }


    }

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