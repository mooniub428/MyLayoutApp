package com.example.mylayoutapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewActivity : AppCompatActivity() {
    val fruitarray = arrayOf("Apple", "Mango", "Banana", "Orange", "PineApple")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)


        val fruit_listview = findViewById<ListView>(R.id.fruit_listview)
        val arrayapdater = ArrayAdapter(this, android.R.layout.simple_list_item_1, fruitarray)

        fruit_listview.adapter = arrayapdater
        fruit_listview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                /*
                * Hanlde Click even of listview
                * */
                val selectedItem = parent.getItemAtPosition(position) as String
                Toast.makeText(this,"Selected Item ==> $selectedItem", Toast.LENGTH_LONG).show()


            }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}