package com.amirovdev.alertdialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Давайте реализуем AlertDialog для того, чтобы пользователь
 * случайно не закрыл приложение кнопкой «назад»
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_to_test_activity.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
//        super.onBackPressed()

        AlertDialog.Builder(ContextThemeWrapper(this, R.style.MyDialog))
            .setTitle("Do you want to leave?")
            .setIcon(R.drawable.ic_action_collections)
            .setMessage("We wouldn't like you to leave")
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No") { _, _ -> }
            .setNeutralButton("I don`t know") { _, _ ->
                Toast.makeText(this, "Decide", Toast.LENGTH_SHORT).show()
            }.show()

        /*
        AlertDialog.Builder(this)
            .setTitle("Вы хотите выйти?")
            .setIcon(R.drawable.ic_action_collections)
            .setPositiveButton("Да") { _, _ ->
                finish()
            }
            .setNegativeButton("Нет") { _, _ ->

            }
            .setNeutralButton("Не знаю") { _, _ ->
                Toast.makeText(this, "Решайся", Toast.LENGTH_SHORT).show()
            }
            .show()
         */
    }
}