package com.example.mylayoutapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import gaur.himanshu.getstartedwithroom.CustomArrayAdapters
import gaur.himanshu.getstartedwithroom.OurData

class CustomListViewActivity : AppCompatActivity() {

    lateinit var customArrayAdapters: CustomArrayAdapters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view)


        val list = mutableListOf<OurData>()
        list.add(OurData(R.drawable.kohli, "Kohli", "Best Batsman"))
        list.add(OurData(R.drawable.amla, "Amla", "Best Batsman of SA"))
        list.add(OurData(R.drawable.bairstow, "Bairstow", "Opener Batsman"))
        list.add(OurData(R.drawable.bales, "Bales", "Bales"))
        list.add(OurData(R.drawable.dhawan, "Shikhar Dhawan", "Indain Opener"))
        list.add(OurData(R.drawable.hardik, "Hardik", "All Rounder"))
        list.add(OurData(R.drawable.mahi, "Mahendra Singh Dhoni", "Former Indian Caption"))
        list.add(OurData(R.drawable.team, "Indain Team", "Men in Blue"))
        list.add(OurData(R.drawable.babar_azam, "Babar Azam", "Batsman"))
        list.add(OurData(R.drawable.hasan_ali, "Hasan Ali", "Bales"))
        list.add(OurData(R.drawable.muhammad_nawaz, "Muhammad Nawaz", "All Rounder"))
        list.add(OurData(R.drawable.iftikhar_ahmed, "Iftikhar Ahmed", "All Rounder"))
        /* Duplicate data added in list
        * */

        customArrayAdapters = CustomArrayAdapters(this, list)

        val listView = findViewById<ListView>(R.id.list)

        listView.adapter = customArrayAdapters

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                //val selectedItem = parent.getItemAtPosition(position) as String
                Toast.makeText(
                    this,
                    "Selected Item ==> ${list.get(position).title}",
                    Toast.LENGTH_LONG
                ).show()

            }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}