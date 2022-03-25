package com.example.internfreak

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internfreak.Adapter.ItemAdapter
import com.example.internfreak.data.company_data
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class SearchActivity : AppCompatActivity() {
    var itemsAdapter: ItemAdapter? = null
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val searchText = findViewById<SearchView>(R.id.searchview_main)
        val recycler_view = findViewById<RecyclerView>(R.id.SearchView_rv)
        searchText.setOnClickListener {
            searchText.isIconified = false
        }
        itemsAdapter = ItemAdapter()
        database = FirebaseDatabase.getInstance().getReference("Company/Internships")
        val dataList = arrayListOf<company_data>()

        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                for (i in p0.children) {

                    val compdat = i.getValue<company_data>()

                    compdat?.let { dataList.add(it) }
                    Log.e(ContentValues.TAG,"user info" +compdat)


                }
                itemsAdapter!!.setData(dataList)
            }
        })

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        recycler_view.adapter = itemsAdapter
        // edittext searchview
        searchText.maxWidth = Int.MAX_VALUE
        searchText.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                itemsAdapter!!.filter.filter(query)
                Log.d("msg", query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                itemsAdapter!!.filter.filter(newText)
                return true
            }
        })
    }
    override fun onStart() {
        super.onStart()
        val searchText = findViewById<SearchView>(R.id.searchview_main)
        searchText.performClick()
    }
}