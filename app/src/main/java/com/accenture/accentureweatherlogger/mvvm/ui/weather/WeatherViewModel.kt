package com.accenture.accentureweatherlogger.mvvm.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.Resource
import com.accenture.accentureweatherlogger.mvvm.repository.model.news.NewsArticles
import com.accenture.accentureweatherlogger.mvvm.repository.repo.news.NewsRepository
import javax.inject.Inject

/**
 * A container for [Main] related data to show on the UI.
 */
class WeatherViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    /**
     * Loading news articles from internet and database
     */
    private fun newsArticles(countryKey: String): LiveData<Resource<List<NewsArticles>?>> =
        newsRepository.getNewsArticles(countryKey)

    fun getNewsArticles(countryKey: String) = newsArticles(countryKey)

    /**
     * Loading news articles from internet only
     */
    private fun newsArticlesFromOnlyServer(countryKey: String) =
        newsRepository.getNewsArticlesFromServerOnly(countryKey)

    fun getNewsArticlesFromServer(countryKey: String) = newsArticlesFromOnlyServer(countryKey)

}