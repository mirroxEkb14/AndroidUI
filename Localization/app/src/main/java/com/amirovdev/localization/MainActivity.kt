package com.amirovdev.localization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Localization ->
 *  go to "string.xml"
 *  "Open Editor" in the right corner
 *  click the 'globe' icon with the green 'plus'
 *  start entering the language name, select a language
 *  in the last column(where there is a language name) enter the text in the necessary language
 *
 *  on the phone:
 *      go to "settings"
 *      go to "languages"
 *      find the necessary language
 *      drag it above all the languages
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}