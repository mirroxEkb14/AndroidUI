package com.amirovdev.intentfilter

import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

/**
 * Intent-filter is a filter for Intents, based on them the System understands
   in what situation what to do. For example: for our app to launch through a
   shortcut on a desktop from a certain Activity, in Manifest file we set the
   following filer:
*
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER"/>
    </intent-filter>
 *
    <category android:name="android.intent.category.LAUNCHER"/> sets a shortcut
    on a desktop so that we see our app
    <action android:name="android.intent.action.MAIN" /> means that the app starts from this Activity
 *
   One app can have two shortcuts for launching, each shortcut will lead to its own Activity
 *
 *
 *
   Intents can be: Explicit (явные) & Implicit (неявные)
   - explicit intents are: when we start an Activity in a class: startActivity(Intent(this, OtherActivity::class.java))
   - implicit intents are: when we set some action that we want to get and we do not specify a component
     or a class of this component (There is no binding to a specific component or component class and is called by action):
    startActivity(Intent("other"), also we need to set this action and category in Manifest:
    <intent-filter>
        <action android:name="other"/>
        <category android:name="android.intent.category.DEFAULT"/>
    </intent-filter>
 *
   The following situation may happen: if we create one more Activity and set to ir the same action, the System
    will find two Activities with such actions and offer a choice what Activity move to
 *
 * There is can also be a situation when there is no app with such action and when launching such a code,
 * the app will crash, so it is needed to make a verification
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainBtn = findViewById<Button>(R.id.main_btn)

        // open a browser
        mainBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)

            intent.putExtra(SearchManager.QUERY, "some query")

//            // if we do not have this Intent in Manifest file, a Toast will be displayed
//            if (intent.resolveActivity(packageManager) != null) {
//                startActivity(intent)
//            } else {
//                Toast.makeText(this, "Sorry, no such app", Toast.LENGTH_SHORT).show()
//            }

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Sorry, no such app", Toast.LENGTH_SHORT).show()
            }
        }
    }
}