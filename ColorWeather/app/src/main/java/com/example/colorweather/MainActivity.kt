package com.example.colorweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.colorweather.data.model.Currently
import com.example.colorweather.data.model.Weather
import com.example.colorweather.data.net.DarkSkyClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    //Desplegar una barra de progreso mientras se carga nuestra informacion
    //Manejar los errores de forma mas adecuada
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWeather()
    }

    private fun getWeather(){
        //Realizando un peticion a Dark Sky para saber el clima
        DarkSkyClient.getWeather().enqueue(object : Callback<Weather>{
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("MainActivity", "Error")
                //Llamar a una funcion que despliegue mensaje de error
                displayErrorMessage()
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                Log.d("BODY", "${response.body()}")
                Log.d("MainActivity", "${response.body()?.currently?.summary}")
                Log.d("Icon", "${response.body()?.currently?.icon}")
                setUpWidgets(response.body()?.currently)
            }

        })
    }

    private fun displayErrorMessage(){
        Toast.makeText(this, "Network Error. Try again later", Toast.LENGTH_LONG).show()
    }

    private fun setUpWidgets(currently: Currently?){
        descriptionTextView.text = currently?.summary ?: "No Data"
        minTempTextView.text = "${currently?.temperature?.roundToInt()}F"
        precipProbTextView.text = "${currently?.precipProbability?.roundToInt()}%"
        iconImageView.setImageResource(getWeatherIcon(currently?.icon ?: "clear_day"))
        datetextView.text = getDateTime()?.capitalize() ?: "No Data"
    }

    private fun getDateTime():String?{
        return try{
            val simpleDateFormat = SimpleDateFormat("MMMM d", Locale.getDefault())
            val date = Calendar.getInstance().time
            simpleDateFormat.format(date)
        }catch (e: Exception){
            e.toString()
        }
    }

    private fun getWeatherIcon(iconString: String): Int{
        return when(iconString){
            "clear-day" -> R.drawable.clear_day
            "clear-night" -> R.drawable.clear_night
            "rain" -> R.drawable.rain
            "snow" -> R.drawable.snow
            "sleet" -> R.drawable.sleet
            "wind" -> R.drawable.wind
            "fog" -> R.drawable.fog
            "cloudy" -> R.drawable.cloudy
            "partly-cloudy-day" -> R.drawable.partly_cloudy_day
            "partly-cloudy-night" -> R.drawable.partly_cloudy_night
            else -> R.drawable.clear_day
        }
    }
}
