package com.arvadeveloper.luckynumber_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)
        var luckyNumber: TextView = findViewById(R.id.luckynumbertxt)
        var shareBtn: Button = findViewById(R.id.sharebtn)
        var username = getUsername()
        var randomNumber = randomNumber().toString()

        shareBtn.setOnClickListener{
            shareNumber(username, randomNumber())
        }
        luckyNumber.setText(randomNumber)
        Toast.makeText(this, "halo "+username+" your lucky number is "+randomNumber, Toast.LENGTH_LONG).show()
    }
    fun getUsername():String{
        var bundle: Bundle? = intent.extras
        var name = bundle?.get("name").toString()
        return name
    }
    fun randomNumber():Int{
        var number = Random.nextInt(1000)
        return number
    }
    fun shareNumber(username:String, number:Int){
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username sedang beruntung hari ini..")
        i.putExtra(Intent.EXTRA_TEXT, "nomor keberuntungan $username adalah $number")
        startActivity(i)
    }
}