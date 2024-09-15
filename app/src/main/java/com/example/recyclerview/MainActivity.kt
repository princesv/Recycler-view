package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.ColorListAdapter

class MainActivity : ComponentActivity(){
    lateinit var colorRecyclerView: RecyclerView
    lateinit var colorList: List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        colorRecyclerView=findViewById(R.id.color_recycler_view)
        colorList= listOf("Red","Blue","Black","Orange","Red","Blue","Black","Orange","Red","Blue","Black","Orange","Red","Blue","Black","Orange","Red","Blue","Black","Orange","Red","Blue","Black","Orange","Red","Blue","Black","Orange","Red","Blue","Black","Orange","Red","Blue","Black");
        colorRecyclerView.layoutManager=LinearLayoutManager(this)
        val colorListAdapter=ColorListAdapter(colorList)
        colorRecyclerView.adapter=colorListAdapter
        colorListAdapter.setOnItemClickListenerFromMainActivity(object : ColorListAdapter.onListItemClickListener{
            override fun onClickListener(position: Int) {
                Toast.makeText(applicationContext,"Item clicked: $position",Toast.LENGTH_SHORT).show()
            }

        })
    }
}

