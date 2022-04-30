package com.amirovdev.keyboardadjusting

/**
   In Manifest the EditText behavior sets in 'activity' attribute
   -> <activity
      android:windowSoftInputMode="adjustNothing"
   here we get the behavior that if EditText is on the bottom of the screen
   and when the user wants tp enter some text, the keyboard appears and
   covers the EditText, so that the user does not see the EditText itself,
   also a part of ImageView is covered
 *
   android:windowSoftInputMode="adjustPan"
   -> all the elements are moved till the EditText is seen, everything is moved
   to the top, it is not recommended (on API 30 is set by default)
 *
   android:windowSoftInputMode="adjustResize"
   -> change the size of the elements(ImageView in our case), it is recommended
   but we must consider: if it is ImageView in ConstraintLayout, the height should
   be 0dp, if there is a text, wrap it in ScrollView
 *
   There us a possibility to manage the interaction with a screen keyboard
   -> window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mainImg: ImageView
    private lateinit var mainEd: EditText
    private lateinit var mainTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        /*
        The variants of button pressing are in the attribute of 'android:imeOptions',
        for example, "actionDone" means the tick, "actionSend" means a send arrow etc.

        If we set ' android:inputType="text" ', then if we have the next EditText -
        there will be ' android:imeOptions="actionNext" ', if there is not the next
        EditText - ' android:imeOptions="actionDone '
        */
        mainEd.setOnEditorActionListener { textView, actionId, keyEvent ->
            // when we click on the tick, the text from EditText goes to TextView
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                mainTv.text = textView.text
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

        /*
        Then we can also set ' android:imeOptions="actionSend" ' in xml and
        'EditorInfo.IME_ACTION_SEND' in the if block, so that the text from the
        EditText will go to the TextView when we click on the send button(send arrow)
        */
    }

    private fun initViews() {
        mainImg = findViewById(R.id.main_img)
        mainEd = findViewById(R.id.main_ed)
        mainTv = findViewById(R.id.main_tv)
    }
}