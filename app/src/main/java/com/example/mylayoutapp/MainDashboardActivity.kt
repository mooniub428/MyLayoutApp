package com.example.mylayoutapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dashboard)
        val buttonAndEditText: Button = findViewById(R.id.button1);
        val buttonCall: Button = findViewById(R.id.button2);
        val buttonCamera: Button = findViewById(R.id.button3);
        val buttonOpenWeb: Button = findViewById(R.id.button4);
        val buttonShare: Button = findViewById(R.id.button5);
        val button6: Button = findViewById(R.id.button6);
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
    }

    private fun handleButtons(i: Int) {
        // showToast("Button $i clicked!")
        if (i == 1) {
            startActivity(Intent(this, MainActivity::class.java).apply {
                // you can add values(if any) to pass to the next class or avoid using `.apply
            })
        } else
            if (i == 2) {
                dialPhoneNumber("12225545")
            } else if (i == 3) {
                showCamera()
            } else if (i == 4) {
                showWebBrowser()
            } else if (i==5){

                shareText("i am sharing text via intent")
            }
        /* if (i == 1) {
             showToast("Button 1 clicked!")
             // Add specific actions for Button 1
         } else if (i == 2) {
             showToast("Button 2 clicked!")
             // Add specific actions for Button 2
         } else {
             showToast("Unknown button clicked!")
             // Add a default action for unknown buttons
         }
 */
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