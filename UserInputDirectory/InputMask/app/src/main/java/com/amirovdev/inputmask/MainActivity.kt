package com.amirovdev.inputmask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Add dependencies:
    implementation 'com.redmadrobot:input-mask-android:6.0.0'
    implementation 'org.jetbrains.kotlin:kotlin-stdlib:1.6.0'
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Создаем слушатель, в который первым параметром передаем шаблон, вторым — наш EditText
        val listener = MaskedTextChangedListener("+7 ([000]) [000]-[00]-[00]", edit_text)

        //Здесь созданный слушатель добавляем к нашему EditText
        edit_text.addTextChangedListener(listener)
        edit_text.onFocusChangeListener = listener
    }
}