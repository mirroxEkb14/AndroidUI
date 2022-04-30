package com.amirovdev.textwatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var mainTv: TextView
    private lateinit var mainEd: EditText
    private lateinit var mainBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val textWatcher = object : TextWatcher {

            // is called before we start the input
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            // is called the we enter the text
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // the text is set in real time
                mainTv.text = p0
            }

            // is called when the input is done
            override fun afterTextChanged(p0: Editable?) {

            }
        }

        // tell EditText that it`s watched
        mainEd.addTextChangedListener(textWatcher)
    }

    private fun initViews() {
        mainTv = findViewById(R.id.main_tv)
        mainEd = findViewById(R.id.main_ed)
        mainBtn = findViewById(R.id.main_btn)
    }
}