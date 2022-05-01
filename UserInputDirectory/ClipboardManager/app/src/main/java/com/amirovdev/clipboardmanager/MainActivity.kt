package com.amirovdev.clipboardmanager

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

/**
   ClipboardManager contains the methods for exchange
   process management and getting inf between component
 *
   ClipData contains the object for passing and its description
 *
   The work with clipboard in Android consists of ClipboardManager and ClipData
 *
   MIME_TYPE is needed to set the type of the passing content
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainBtn = findViewById<Button>(R.id.main_btn)

        mainBtn.setOnClickListener {
            // get the object of ClipboardManager and bring it to the ClipboardManager class
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

            // create clipData object for creating an object for copying,
            // newPlainText method puts there the inf
            // *if we want, we can get label(part of Description) 'text.text = clipData.description.label.toString()'
            val clipData = ClipData.newPlainText("Text", "This is text from MyApplication")

            // pass the text to the Provider (can hold only one ClipData object at the same time)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Text put to buffer", Toast.LENGTH_SHORT).show()
        }
    }
}