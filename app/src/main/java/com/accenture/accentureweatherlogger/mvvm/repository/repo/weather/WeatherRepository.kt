package com.accenture.accentureweatherlogger.mvvm.repository.repo.weather

import android.content.Context
import androidx.lifecycle.LiveData
import com.accenture.accentureweatherlogger.mvvm.BuildConfig
import com.accenture.accentureweatherlogger.mvvm.app.AppExecutors
import com.accenture.accentureweatherlogger.mvvm.repository.api.ApiServices
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.NetworkAndDBBoundResource
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.NetworkResource
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.Resource
import com.accenture.accentureweatherlogger.mvvm.repository.db.weather.WeatherDao
import com.accenture.accentureweatherlogger.mvvm.repository.model.news.NewsSource
import com.accenture.accentureweatherlogger.mvvm.repository.model.weather.Main
import com.accenture.accentureweatherlogger.mvvm.repository.model.weather.WeatherSource
import com.accenture.accentureweatherlogger.mvvm.utils.ConnectivityUtil
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class WeatherRepository @Inject constructor(
    private val weatherDao: WeatherDao,
    private val apiServices: ApiServices, private val context: Context,
    private val appExecutors: AppExecutors = AppExecutors()
) {

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */

    fun getWeatherInfo(countryShortKey: String): LiveData<Resource<Main?>> {

        val data = HashMap<String, String>()
        data.put("country", countryShortKey)
        data.put("apiKey", BuildConfig.WEATHER_API_KEY)

        return object : NetworkAndDBBoundResource<Main, WeatherSource>(appExecutors) {
            override fun saveCallResult(item: WeatherSource) {
                    weatherDao.deleteAllWeathers()
                    weatherDao.insertWeather(item.main)
            }

            override fun shouldFetch(data: Main?) =
                (ConnectivityUtil.isConnected(context))

            override fun loadFromDb() = weatherDao.getWeather()

            override fun createCall() =
                apiServices.getWeatherSource(data)

        }.asLiveData()
    }

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     * LiveData<Resource<NewsSource>>
     */
    fun getWeatherInfoFromServerOnly(countryShortKey: String):
            LiveData<Resource<WeatherSource>> {

        val data = HashMap<String, String>()
        data["country"] = countryShortKey
        data["apiKey"] = BuildConfig.WEATHER_API_KEY

        return object : NetworkResource<WeatherSource>() {
            override fun createCall(): LiveData<Resource<WeatherSource>> {
                return apiServices.getWeatherSource(data)
            }

        }.asLiveData()
    }

}