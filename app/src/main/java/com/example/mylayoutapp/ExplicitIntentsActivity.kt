package com.example.mylayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylayoutapp.databinding.ActivityMainBinding

class ExplicitIntentsActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}