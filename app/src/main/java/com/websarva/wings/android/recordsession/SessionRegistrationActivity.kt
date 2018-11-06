package com.websarva.wings.android.recordsession

import android.app.DatePickerDialog
import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_session_registration.*
import java.text.SimpleDateFormat
import java.util.*


class SessionRegistrationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session_registration)

        val textView = findViewById(R.id.tw_start_time) as TextView
        textView.setOnClickListener {

            val datePicker = DatePickerDialogFragment()
            datePicker.show(supportFragmentManager, "datePicker")
        }
    }
}

class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val yearget = calendar.get(Calendar.YEAR)
        val monthget = calendar.get(Calendar.MONTH)
        val dayget = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, this, yearget, monthget, dayget)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {

        val textView = activity!!.findViewById(R.id.tw_start_time) as TextView
        textView.text = year.toString()+ "年" + month.toString() + "月" + day.toString() + "日"
    }
}