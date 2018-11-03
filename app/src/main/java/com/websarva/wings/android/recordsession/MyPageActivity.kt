package com.websarva.wings.android.recordsession

import android.os.Bundle
import android.app.Activity
import android.content.Intent

import kotlinx.android.synthetic.main.activity_my_page.*

class MyPageActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        bt_transition_session_register.setOnClickListener {
            val intent = Intent(application, SessionRegistrationActivity::class.java)
            startActivity(intent)
        }
    }


}
