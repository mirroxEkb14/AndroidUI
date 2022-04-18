package com.amirovdev.statesaving

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * When we flip the device, the configuration is changed from 'portrait'
 * to 'landscape' and Activity is destroyed with all unsaved data.
 *
 * In this exmaple, after typing the text in EditText and clicking the Button,
 * TextView has the text from EditText, then we flip the device and TextView
 * text becomes "Hello World!"(default value), because Activity is destroyed
 * after flipping the screen.
 * With the help of 'onSaveInstanceState(outState: Bundle)' and 'onRestoreInstanceState(savedInstanceState: Bundle)'
 * methods we can save data(values from the screen) and then assign them in newborn Activity
 *
 * In <activity> tag in AndroidManifest.xml we can write ' android:screenOrientation="portrait" ',
 * so the orientation will always be vertical
 */

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)
        editText = findViewById(R.id.edit_text)
        button = findViewById(R.id.btn)

        button.setOnClickListener {
            textView.text = editText.text
        }
    }

    // we save all the variables in 'outState'
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // put the text in Bundle to save it when changing configuration
        // first argument is a key by which we will find the field
        outState.putString("text", textView.text.toString())
    }

    // restore the data
    // 'savedInstanceState' - our saved TextView
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // take a value from saved Bundle and put it in our text field
        // the second argument - default value if nothing was found by this key or it is 'null'
        textView.text = savedInstanceState.getString("text", "defaultValue")
    }
}