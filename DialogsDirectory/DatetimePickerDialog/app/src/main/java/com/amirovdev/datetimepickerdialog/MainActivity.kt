package com.amirovdev.datetimepickerdialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // at the moment we set the date or time,
        // we already have the current data and time by default
        val calendar = Calendar.getInstance()
        val curYear = calendar.get(Calendar.YEAR)
        val curMonth = calendar.get(Calendar.MONTH)
        val curDay = calendar.get(Calendar.DAY_OF_MONTH)
        val curHour = calendar.get(Calendar.HOUR_OF_DAY)
        val curMinute = calendar.get(Calendar.MINUTE)

        // get date (months start with 0)
        btn_date_picker.setOnClickListener {
            DatePickerDialog(this, { view, year, month, dayOfMonth ->
                val date = "date -> $dayOfMonth.${month + 1}.$year"
                datetime_text.text = date
            },
            curYear, curMonth, curDay).show()
        }

        // get time
        btn_time_picker.setOnClickListener {
            val timePicker = TimePickerDialog.OnTimeSetListener {view, hourOfDay, minute ->
                val time = "time -> $hourOfDay:$minute"
                datetime_text.text = time
            }
            TimePickerDialog(this, timePicker, curHour, curMinute, true).show()
        }

        // get date + time
        btn_datetime_picker.setOnClickListener {
            DatePickerDialog(this, { view, year, month, dayOfMonth ->
                val date = "date -> $dayOfMonth.${month + 1}.$year"

                val timePicker = TimePickerDialog.OnTimeSetListener {view, hourOfDay, minute ->
                    val time = "time -> $hourOfDay:$minute $date"
                    datetime_text.text = time
                }

                TimePickerDialog(this, timePicker, curHour, curMinute, true).show()
            },
                curYear, curMonth, curDay).show()
        }
    }
}