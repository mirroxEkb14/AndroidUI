package com.amirovdev.inputfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // user cannot enter more than 5 symbols
        val inputFilter1 = InputFilter { source, start, end, spanned, dstart, dend ->
            if (source.length <= 5) {
                return@InputFilter source
            }
            Toast.makeText(this, "Character limit is 5", Toast.LENGTH_SHORT).show()
            spanned.toString() // return the string variant
        }

//        // the user cannot enter the 'e' character
//        val inputFilter2 = InputFilter { source, start, end, spanned, dstart, dend ->
//            if (source.contains("e")) {
//                Toast.makeText(this, "Sorry no e", Toast.LENGTH_SHORT).show()
//                return@InputFilter spanned
//            }
//            source.toString()
//        }

        findViewById<EditText>(R.id.main_ed).filters = arrayOf(inputFilter1)

        /*
            By default we can set:
            InputFilter.AllCaps() -> all the input symbols will be in capital letters
            InputFilter.LengthFilter() -> limits the string length
        */
    }
}