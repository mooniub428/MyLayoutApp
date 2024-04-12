package com.example.mylayoutapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DialogBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dialog_box)
        val simple_dialogbox_button: Button = findViewById(R.id.simple_dialogbox_button)
        simple_dialogbox_button.setOnClickListener(View.OnClickListener {

            simpleShowDialog(this)
        })

        val custom_dialogbox_button: Button = findViewById(R.id.custom_dialogbox_button)

        custom_dialogbox_button.setOnClickListener(View.OnClickListener {
            showCustomDialog(this)

        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun simpleShowDialog(context: Context) {
        val alertDialogBuilder = AlertDialog.Builder(context)

        // Set the title and message
        alertDialogBuilder.setTitle("Dialog Title")
        alertDialogBuilder.setMessage("This is a sample dialog message.")

        // Set positive button
        alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
            // Handle positive button click if needed
            // For example, you can perform some action or dismiss the dialog
            dialog.dismiss()
        }

        // Set negative button (optional)
        alertDialogBuilder.setNegativeButton("Cancel") { dialog, which ->
            // Handle negative button click if needed
            dialog.dismiss()
        }

        // Show the dialog
        alertDialogBuilder.show()
    }

}

fun showCustomDialog(context: Context) {
    // Inflate the custom layout
    val dialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)

    // Create AlertDialog builder
    val builder = AlertDialog.Builder(context)
        .setView(dialogView)
        .setTitle("Custom Dialog")

    // Initialize views from custom layout
    val editText = dialogView.findViewById<EditText>(R.id.edit_text)
    val positiveButton = dialogView.findViewById<Button>(R.id.positive_button)
    val negativeButton = dialogView.findViewById<Button>(R.id.negative_button)

    // Create and show the dialog
    val dialog = builder.create()
    dialog.show()

    // Set positive button click listener
    positiveButton.setOnClickListener {
        val inputText = editText.text.toString()
        // Do something with the input text
        Toast.makeText(context, "Entered text: $inputText", Toast.LENGTH_SHORT).show()
        dialog.dismiss()
    }

    // Set negative button click listener
    negativeButton.setOnClickListener {
        dialog.dismiss()
    }
}
