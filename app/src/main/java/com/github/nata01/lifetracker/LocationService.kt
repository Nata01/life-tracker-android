package com.github.nata01.lifetracker

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle

class LocationService(private val locationManager : LocationManager) {
    @SuppressLint("MissingPermission")
    fun getLocation(cb: (Location) -> Unit){
        val ll = object: LocationListener {
            override fun onLocationChanged(location: Location?) {
                cb(location!!)
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            }

            override fun onProviderEnabled(provider: String?) {
            }

            override fun onProviderDisabled(provider: String?) {
            }
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000L,500.0f, ll)
    }

}
