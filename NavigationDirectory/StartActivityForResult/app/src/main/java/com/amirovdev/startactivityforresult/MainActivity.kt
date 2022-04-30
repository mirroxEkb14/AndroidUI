package com.amirovdev.startactivityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * requestCode is needed to know from what Activity the result came if
 * we launch more than one Activity for the result
 *
 * to return the result from Activity we need to call setResult(resultCode, intent)
 *
 * resultCode is needed to notify the receiving Activity how the receiving result process goes
 */

class MainActivity : AppCompatActivity() {

    private lateinit var mainTv: TextView
    private lateinit var mainBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        mainBtn.setOnClickListener {
            val intent = Intent(this, AnotherActivity::class.java)
            startActivityForResult(intent, SUCCESS_CODE_REQUEST)
        }
    }

    // process the passed data in this Activity(because we need a result in this Activity)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null) return

        if (requestCode == SUCCESS_CODE_REQUEST) {
            if (resultCode == SUCCESS_CODE_RESULT) {
                val string = "${mainTv.text} ${data.getStringExtra("result")}"
                mainTv.text = string
            }
        }
    }

    // constants for 'setResult' method in AnotherActivity and
    // 'startActivityForResult' method in MainActivity
    companion object CodeConstants {
        const val SUCCESS_CODE_REQUEST = 111
        const val SUCCESS_CODE_RESULT = 0
    }

    private fun initViews() {
        mainTv = findViewById(R.id.main_tv)
        mainBtn = findViewById(R.id.main_btn)
    }
}