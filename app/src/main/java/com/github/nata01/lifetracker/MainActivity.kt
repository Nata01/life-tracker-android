package com.github.nata01.lifetracker

import android.content.Context
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationService = LocationService(getSystemService(Context.LOCATION_SERVICE) as LocationManager)
        val requestService = RequestService()

        location_btn.setOnClickListener {
            locationService.getLocation {
                requestService.makeRequest(UserLocationDto(it.latitude.toString(), it.longitude.toString())) { res ->
                    runOnUiThread{location_btn.text = res}
                }
            }
        }
    }
}
