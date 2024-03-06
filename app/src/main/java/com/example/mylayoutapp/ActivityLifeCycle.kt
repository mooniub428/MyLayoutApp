package com.example.mylayoutapp

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mylayoutapp.databinding.ActivityLifeCycleBinding

class ActivityLifeCycle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.d("ActivityLifeCycle","----onCreate---")

    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifeCycle","----onStart---")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifeCycle","----onResume---")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifeCycle","----onPause---")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifeCycle","----onStop---")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifeCycle","----onDestroy---")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityLifeCycle","----onRestart---")
    }
}