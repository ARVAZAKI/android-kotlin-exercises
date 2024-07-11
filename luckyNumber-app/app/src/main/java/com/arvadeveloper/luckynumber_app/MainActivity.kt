package com.arvadeveloper.luckynumber_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nameTxt: EditText = findViewById(R.id.inputName)
        var displayTxt: TextView = findViewById(R.id.displayNumber)
        var submitBtn: Button = findViewById(R.id.btnSubmit)

        submitBtn.setOnClickListener{
            var name = nameTxt.text
            var i = Intent(this, LuckyNumberActivity::class.java)
            i.putExtra("name", name)
            startActivity(i)
        }

    }
}