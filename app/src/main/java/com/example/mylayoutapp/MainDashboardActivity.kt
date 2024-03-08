package com.example.mylayoutapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainDashboardActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dashboard)
        val buttonAndEditText: Button = findViewById(R.id.buttonAndEditText);
        val buttonCall: Button = findViewById(R.id.button2);
        val buttonCamera: Button = findViewById(R.id.button3);
        val buttonOpenWeb: Button = findViewById(R.id.button4);
        val buttonShare: Button = findViewById(R.id.button5);
        val buttonActivityLifeCycle: Button = findViewById(R.id.activity_life_cycle_button);
        val buttonAlertDialog: Button = findViewById(R.id.alert_dialog_button);
        buttonAlertDialog.setOnClickListener(View.OnClickListener {
            handleButtons(7)
        })
        buttonCall.setOnClickListener(View.OnClickListener {

            handleButtons(2)
        })
        buttonAndEditText.setOnClickListener(View.OnClickListener {

            handleButtons(1)
        })
        buttonCamera.setOnClickListener(View.OnClickListener {

            handleButtons(3)
        })
        buttonOpenWeb.setOnClickListener(View.OnClickListener {
            handleButtons(4)
        })
        buttonShare.setOnClickListener(View.OnClickListener {
            handleButtons(5)

        })
        buttonActivityLifeCycle.setOnClickListener(View.OnClickListener {

            handleButtons(6)

        })
    }

    private fun handleButtons(i: Int) {
        // showToast("Button $i clicked!")
        if (i == 1) {
            startActivity(Intent(this, MainActivity::class.java).apply {
                // you can add values(if any) to pass to the next class or avoid using `.apply
            })
        } else
            if (i == 2) {
                dialPhoneNumber("+9230000000")
            } else if (i == 3) {
                showCamera()
            } else if (i == 4) {
                showWebBrowser()
            } else if (i == 5) {

                shareText("i am sharing text via intent")
            } else if (i == 6) {

                startActivity(Intent(this, ActivityLifeCycle::class.java).apply {
                    // you can add values(if any) to pass to the next class or avoid using `.apply
                })
            }else if (i == 7) {

                showDialog()
            }
    }
    private fun showDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)

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

        // Create and show the dialog
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
    private fun shareText(text: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, text)

        // Optionally, you can add a subject for the shared content
        // shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject for the shared content")

        // Start the chooser to select an app for sharing
        startActivity(Intent.createChooser(shareIntent, "Share using"))
    }

    private fun showWebBrowser() {
        val url = "https://www.kfueit.edu.pk/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
        // Check if there's a browser activity that can handle the intent
    }

    private fun showCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            // Handle the case where the camera app is not installed
            // or no activity can handle the intent.
            // You might want to show a message or prompt the user to install a camera app.
            Toast.makeText(this, "No camera app found", Toast.LENGTH_SHORT).show()
        }
    }

    fun dialPhoneNumber(phoneNumber: String) {

        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)

    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()

    }
}