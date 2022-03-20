package com.example.internfreak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.Adapter.applications_list_Adapter
import com.example.internfreak.data.data1
import com.example.internfreak.data.dataapplications
import java.lang.Boolean.TRUE

class Applications_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applications)

        val data1= arrayListOf<dataapplications>()


        data1.add(dataapplications(R.drawable.amazon,"Rachel","nyc","Android developer"))
        data1.add(dataapplications(R.drawable.infosyslimited,"Chandler","NYC","Web Devloper"))



        val recycler = findViewById<RecyclerView>(R.id.applications_rv)
        recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        recycler.adapter = applications_list_Adapter(data1)
    }
}
