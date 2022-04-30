package com.amirovdev.customkeyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
   InputMethodService is a data entry service(for keywords), thanks to it we can pass
   data to EdiText. It is a bit 'Depricated'
   The advantages of soft keyboard are: adapts to the content
                                        can be customized
 *
   Create the main layout for the keyboard
   -> 'custom_keyboard.xml'

   Create preview for a button
   -> 'keyboard_preview.xml'

   Create a xml directory
   -> res → New → Android Resource Directory → Resource type: xml

   Create a button markup and its table
   -> num_pad.xml

   Create a flag for the System
   -> method.xml

   Create a class for processing all the xml-files
   -> InputMethodServiceImpl.kt

   Register our keyboard in the Manifest because it`s a service
   -> manifests → AndroidManifest.xml

   Enable our keyboard in the system Settings
   -> Settings → System → Language & Input → On-screen keyboard → Manage on-screen keyboards
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}