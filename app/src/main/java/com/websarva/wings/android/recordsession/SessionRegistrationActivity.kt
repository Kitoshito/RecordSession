package com.websarva.wings.android.recordsession

import android.app.DatePickerDialog
import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_session_registration.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * スタートアップオブジェクト
 */
class SessionRegistrationActivity : AppCompatActivity(), TextWatcher {

    private var tvPlCode2: TextView? = null
    private var etPlCode2: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session_registration)

        //画面を閉じてTOP画面に戻る
        bt_return.setOnClickListener{
            finish()
        }

        //日付ダイアログを表示して値を取得
        val textView = findViewById<TextView>(R.id.tw_start_time)
        textView.setOnClickListener {

            val datePicker = DatePickerDialogFragment()
            datePicker.show(supportFragmentManager, "datePicker")
        }

        tvPlCode2 = findViewById(R.id.tv_pl_code2)
        etPlCode2 = findViewById(R.id.et_pl_code2)

        //afterTextChangedのためのやーつ
        val plCode1 = findViewById<EditText>(R.id.et_pl_code1)
        plCode1.addTextChangedListener(this)

    }

    //値が入ればEditTextを表示したい
    override fun afterTextChanged(p0: Editable?) {

        if(p0 == null) {
            print("p0")
            return
        }
        val inputStr = p0.toString()
        if(inputStr == null) {
            print("inputStr")
            return
        }
        val inputLength = inputStr.length
        if(inputLength > 0 && tvPlCode2 != null && etPlCode2 != null) {
            tvPlCode2?.visibility = View.VISIBLE
            etPlCode2?.visibility = View.VISIBLE
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

/**
 * 日付ダイアログを表示して、ユーザが選択した値をTextViewにストアする。
 */
class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val yearGet = calendar.get(Calendar.YEAR)
        val monthGet = calendar.get(Calendar.MONTH)
        val dayGet = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, this, yearGet, monthGet, dayGet)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {

        val textView = activity!!.findViewById<TextView>(R.id.tw_start_time)
        textView.text = year.toString()+ "年" + month.toString() + "月" + day.toString() + "日"
    }
}
