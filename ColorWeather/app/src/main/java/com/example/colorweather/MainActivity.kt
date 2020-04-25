package com.example.colorweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.colorweather.data.model.Currently
import com.example.colorweather.data.model.Weather
import com.example.colorweather.data.net.DarkSkyClient
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.design.indefiniteSnackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    //Manejar los errores de forma mas adecuada

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWeather()
    }

    private fun getWeather(){
        //Desplegar nuestra progress bar
        displayProgressBar(true)
        displayUI(false)
        //Queremos que nuestros componentes sean invisibles
        //Realizando un peticion a Dark Sky para saber el clima
        DarkSkyClient.getWeather().enqueue(object : Callback<Weather>{
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.d("MainActivity", "Error")
                //Oculte nuestra progress bar
                displayProgressBar(false)
                //Llamar a una funcion que despliegue mensaje de error
                displayErrorMessage()
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                Log.d("BODY", "${response.body()}")
                Log.d("MainActivity", "${response.body()?.currently?.summary}")
                Log.d("Icon", "${response.body()?.currently?.icon}")
                //Ocultar nuestra progress bar
                displayProgressBar(false)
                displayUI(true)
                //Desplegar nuestra UI
                setUpWidgets(response.body()?.currently)
            }

        })
    }

    private fun displayUI(visible: Boolean){
        datetextView.visibility = if(visible) View.VISIBLE else View.GONE
        iconImageView.visibility = if(visible) View.VISIBLE else View.GONE
        descriptionTextView.visibility = if(visible) View.VISIBLE else View.GONE
        minTempTextView.visibility = if(visible) View.VISIBLE else View.GONE
        precipProbTextView.visibility = if(visible) View.VISIBLE else View.GONE
        dailyButton.visibility = if(visible) View.VISIBLE else View.GONE
        hourlyButton.visibility = if(visible) View.VISIBLE else View.GONE
    }

    private fun displayProgressBar(visible: Boolean){
        progressBar.visibility = if (visible) View.VISIBLE else View.GONE
    }

    private fun displayErrorMessage(){
        mainLayout.indefiniteSnackbar("Network Error. Try Again?", "OK"){
            getWeather() //llama a esta funcion cuando se presiona el boton OK
        }
        //Toast.makeText(this, "Network Error. Try again later", Toast.LENGTH_LONG).show()
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

    fun startDailyActivity(view: View){
        //Crear un intent que intente ir a daily activity
        val intent = Intent(this, DailyActivity::class.java)
        //Ir a la daily activity
        startActivity(intent)
    }

    fun startHourlyActivity(view: View){
        //Crear un intent que intente ir a hourly activity
        val intent = Intent(this, HourlyActivity::class.java)
        //Ir a la hourly activity
        startActivity(intent)
    }

}
