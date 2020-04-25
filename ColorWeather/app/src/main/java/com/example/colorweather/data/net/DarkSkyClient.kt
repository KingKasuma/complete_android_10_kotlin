package com.example.colorweather.data.net

import com.example.colorweather.data.model.Weather
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DarkSkyClient {

    private val darSkyApi: DarkSkyApi

    private const val API_KEY = "273674e62807b69b223b7c5edebcabd0"
    private const val DARK_SKY_URL = "https://api.darksky.net/"
    private val coordinates = Pair("37.8267", "-122.4233")

    init {
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(DARK_SKY_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        darSkyApi = retrofit.create(DarkSkyApi::class.java)
    }

    fun getWeather(latitude: String = coordinates.first,
                   longitude: String = coordinates.second): Call<Weather>{
        return darSkyApi.getWeather(API_KEY, latitude, longitude)
    }

}