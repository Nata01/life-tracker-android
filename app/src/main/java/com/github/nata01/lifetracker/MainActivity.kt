package com.github.nata01.lifetracker

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceIntent = Intent(applicationContext, BackgroundLocationService::class.java)
        val restartServicePI = PendingIntent.getService(
            applicationContext, 1, serviceIntent, 0
        )

        val am = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 60000, restartServicePI)
    }
}
