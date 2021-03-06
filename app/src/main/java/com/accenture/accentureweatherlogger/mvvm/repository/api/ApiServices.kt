package com.accenture.accentureweatherlogger.mvvm.repository.api

import androidx.lifecycle.LiveData
import com.accenture.accentureweatherlogger.mvvm.BuildConfig
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.Resource
import com.accenture.accentureweatherlogger.mvvm.repository.model.news.NewsSource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import android.R.string.no
import com.accenture.accentureweatherlogger.mvvm.repository.model.weather.WeatherSource


/**
 * Created by Waheed on 04,November,2019
 */

/**
 * Api services to communicate with server
 *
 */
interface ApiServices {

    /**
     * Fetch news articles from Google news using GET API Call on given Url
     * Url would be something like this top-headlines?country=my&apiKey=XYZ
     */
    @GET("top-headlines")
    fun getNewsSource(@QueryMap options: Map<String, String>): LiveData<Resource<NewsSource>>

    @GET("weather")
    fun getWeatherSource(@QueryMap options: Map<String, String>): LiveData<Resource<WeatherSource>>




    /**
     * Fetch news articles from Google news using GET API Call on given Url
     * Using Call, By Retrofit
     */
    @GET("top-headlines?sources=google-news&apiKey=" + BuildConfig.WEATHER_API_KEY)
    fun getWeatherSourceUsingCall(): Call<WeatherSource>

}
