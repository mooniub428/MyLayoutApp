package com.example.mylayoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn1)
        val editMyTextText = findViewById<EditText>(R.id.editMyTextText)
        button.setOnClickListener(View.OnClickListener {
            val myValues = editMyTextText.text.toString()
           // Toast.makeText(this, "button clicked --> "+myValues, Toast.LENGTH_LONG).show()

            startActivity(Intent(this, MainDashboardActivity::class.java).apply {
                // you can add values(if any) to pass to the next class or avoid using `.apply
            })
        })
    }
}