package com.example.colorweather.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colorweather.R
import com.example.colorweather.data.model.Data
import com.example.colorweather.ui.adapters.DailyAdapter
import kotlinx.android.synthetic.main.activity_daily.*

class DailyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)
        val dailyData: ArrayList<Data>? = intent.getParcelableArrayListExtra(MainActivity.DAILY_DATA)
        val dailyAdapter = DailyAdapter(dailyData)
        dailyReciclerView.layoutManager = LinearLayoutManager(this)
        dailyReciclerView.adapter = dailyAdapter
    }
}
