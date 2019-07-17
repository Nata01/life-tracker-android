package com.github.nata01.lifetracker

import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.IBinder


class BackgroundLocationService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null;
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val locationService = LocationService(getSystemService(Context.LOCATION_SERVICE) as LocationManager)
        val requestService = RequestService()

        locationService.getLocation {
            val userLocationDto = UserLocationDto(it.latitude.toString(), it.longitude.toString())
            requestService.makeRequest(userLocationDto) { res ->
            }
        }
        return START_STICKY
    }
}
