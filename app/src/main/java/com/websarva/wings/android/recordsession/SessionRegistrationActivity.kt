package com.websarva.wings.android.recordsession

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_session_registration.*
import java.text.SimpleDateFormat
import java.util.*


class SessionRegistrationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session_registration)

        bt_return.setOnClickListener{
            finish()
        }
    }
}
/*
class SessionRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session_registration)
        val textView: TextView = findViewById(R.id.textView_date)
        textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
        var cal = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener {
            view, year, monthOfYear, dayOfMonth
        } -> cal.set(Calendar.YEAR, year) cal.set(Calendar.MONTH, monthOfYear)
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        val myFormat = "dd.MM.yyyy"

        // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textView.text = sdf.format(cal.time) }
        textView.setOnClickListener {
            DatePickerDialog(this@MainActivity
                    , dateSetListener
                    , cal.get(Calendar.YEAR)
                    , cal.get(Calendar.MONTH)
                    , cal.get(Calendar.DAY_OF_MONTH)
            ).show()
    }
}
}
*/