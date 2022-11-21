package com.example.recyclerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerexample.data.MyAdapter

class MainActivity : AppCompatActivity() {

    val myAdapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecView()
    }

    private fun initRecView() {
        val recView = findViewById<RecyclerView>(R.id.recView)
        recView.layoutManager = LinearLayoutManager(this)
        recView.adapter  = myAdapter
    }
}