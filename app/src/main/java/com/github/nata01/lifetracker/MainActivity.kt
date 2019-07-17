package com.github.nata01.lifetracker

import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        location_btn.setOnClickListener {
            val serviceIntent = Intent(applicationContext, BackgroundLocationService::class.java)
            startService(serviceIntent)
        }
    }
}
