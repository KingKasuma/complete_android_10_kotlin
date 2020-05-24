package com.example.colorweather.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.colorweather.R
import com.example.colorweather.data.model.Data
import com.example.colorweather.ui.convertTime
import kotlinx.android.synthetic.main.list_item.view.*

class DailyAdapter(private val data: List<Data>?): RecyclerView.Adapter<DailyAdapter.DailyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return DailyHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: DailyHolder, position: Int) {
        data?.let {
            holder.bind(it[position])
        }
    }

    inner class DailyHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bind(data: Data) = with(view){
            dailySummaryTextView.text = data.summary
            dailyDateTextView.text = convertTime(data.time, "MMMM dd")
        }
    }

}