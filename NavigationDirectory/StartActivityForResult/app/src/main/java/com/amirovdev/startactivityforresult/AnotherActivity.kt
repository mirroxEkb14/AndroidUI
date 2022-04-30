package com.amirovdev.startactivityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class AnotherActivity : AppCompatActivity() {

    private lateinit var anotherEd: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        initViews()
    }

    // when we go back to MainActivity, the text from EditText is collected
    // and goes to TextView in activity_main
    override fun onBackPressed() {
        val intent = Intent()
        val text = anotherEd.text.toString()
        intent.putExtra("result", text)
        setResult(MainActivity.SUCCESS_CODE_RESULT, intent) // pass 0 as a code execution success
        super.onBackPressed()
    }

    private fun initViews() {
        anotherEd = findViewById(R.id.another_et)
    }
}