package com.github.nata01.lifetracker

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalStateException
import java.util.*

class BackgroundLocationService : IntentService(BackgroundLocationService::class.java.simpleName) {

    override fun onHandleIntent(intent: Intent?) {
        val locationService = LocationService(getSystemService(Context.LOCATION_SERVICE) as LocationManager)
        val requestService = RequestService()

//        Timer().scheduleAtFixedRate(object : TimerTask() {
//            override fun run() {
                locationService.getLocation {
                    val userLocationDto = UserLocationDto(it.latitude.toString(), it.longitude.toString())
                    requestService.makeRequest(userLocationDto) { res ->
                    }
                }
//            }
//        }, 0, 5000)
    }
}
