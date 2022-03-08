package com.example.internfreak.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.Adapter.Connect_Adapter
import com.example.internfreak.R
import com.example.internfreak.data.data1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Connect.newInstance] factory method to
 * create an instance of this fragment.
 */
class Connect : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data= arrayListOf<data1>()

        data.add(data1(R.drawable.amazon,"Amazon"))
        data.add(data1(R.drawable.infosyslimited,"Infosys"))
        data.add(data1(R.drawable.netflixlogo,"Netflix"))
        data.add(data1(R.drawable.tcs,"TCS"))


        val recycler = view.findViewById<RecyclerView>(R.id.connect_rv)
        recycler.layoutManager = GridLayoutManager(view.getContext(),2)
        //LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        recycler.adapter = Connect_Adapter(data)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connect, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Connect.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Connect().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}