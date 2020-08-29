package com.accenture.accentureweatherlogger.mvvm.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.Resource
import com.accenture.accentureweatherlogger.mvvm.repository.model.news.NewsArticles
import com.accenture.accentureweatherlogger.mvvm.repository.model.weather.Main
import com.accenture.accentureweatherlogger.mvvm.repository.model.weather.WeatherData
import com.accenture.accentureweatherlogger.mvvm.repository.repo.weather.WeatherRepository
import javax.inject.Inject

/**
 * A container for [Main] related data to show on the UI.
 */
class WeatherInfoViewModel @Inject constructor(

    private val weatherRepository: WeatherRepository
) : ViewModel() {

    /**
     * Loading news articles from internet and database
     */
    private fun weatherInfo(cityKey: String): LiveData<Resource<Main?>> =
        weatherRepository.getWeatherInfo(cityKey)

    fun getWeatherInfo(cityKey: String) = weatherInfo(cityKey)

    /**
     * Loading news articles from internet only
     */
    private fun weatherInfoFromOnlyServer(cityKey: String) =
        weatherRepository.getWeatherInfoFromServerOnly(cityKey)

    fun getWeatherInfoFromServer(cityKey: String) = weatherInfoFromOnlyServer(cityKey)

}