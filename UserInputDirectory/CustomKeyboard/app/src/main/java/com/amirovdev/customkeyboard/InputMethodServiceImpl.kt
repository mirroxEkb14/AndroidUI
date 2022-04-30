package com.amirovdev.customkeyboard

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.View

/**
 * A class for processing all the xml-files
 */

@Suppress("DEPRECATION")
// inherit from 'InputMethodService()' and apply the 'KeyboardView.OnKeyboardActionListener' listener,
// override the necessary methods
class InputMethodServiceImpl : InputMethodService(), KeyboardView.OnKeyboardActionListener {

    // connect all the markups and a listener
    override fun onCreateInputView(): View {
        val keyboardView = layoutInflater.inflate(R.layout.custom_keyboard, null) as KeyboardView
        val keyboard = Keyboard(this, R.xml.num_pad)
        keyboardView.keyboard = keyboard
        keyboardView.setOnKeyboardActionListener(this)

        return keyboardView
    }
    override fun swipeRight() {}
    override fun onPress(p0: Int) {}
    override fun onRelease(p0: Int) {}
    override fun swipeLeft() {}
    override fun swipeUp() {}
    override fun swipeDown() {}

    // we need to override only this method for now
    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {

        // call the connection with the input service and process the clicks
        currentInputConnection?.commitText(primaryCode.toString(), 1)
    }

    override fun onText(p0: CharSequence?) {}
}