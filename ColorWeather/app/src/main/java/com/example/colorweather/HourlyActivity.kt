package com.example.colorweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_hourly.*
import java.util.ArrayList

class HourlyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hourly)
        val summary = intent.getStringArrayExtra("HOURLY_SUMMARY")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, summary)
        hourlyWeatherList.adapter = adapter
    }
}
