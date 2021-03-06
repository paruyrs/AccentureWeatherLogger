package com.accenture.accentureweatherlogger.mvvm.repository.repo.news

import android.content.Context
import androidx.lifecycle.LiveData
import com.accenture.accentureweatherlogger.mvvm.BuildConfig
import com.accenture.accentureweatherlogger.mvvm.app.AppExecutors
import com.accenture.accentureweatherlogger.mvvm.repository.api.ApiServices
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.NetworkAndDBBoundResource
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.NetworkResource
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.Resource
import com.accenture.accentureweatherlogger.mvvm.repository.db.news.NewsArticlesDao
import com.accenture.accentureweatherlogger.mvvm.repository.model.news.NewsArticles
import com.accenture.accentureweatherlogger.mvvm.repository.model.news.NewsSource
import com.accenture.accentureweatherlogger.mvvm.utils.ConnectivityUtil
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Waheed on 04,November,2019
 */

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 *
 */

@Singleton
class NewsRepository @Inject constructor(
    private val newsDao: NewsArticlesDao,
    private val apiServices: ApiServices, private val context: Context,
    private val appExecutors: AppExecutors = AppExecutors()
) {

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */
    fun getNewsArticles(countryShortKey: String): LiveData<Resource<List<NewsArticles>?>> {

        val data = HashMap<String, String>()
        data.put("country", countryShortKey)
        data.put("apiKey", BuildConfig.WEATHER_API_KEY)

        return object : NetworkAndDBBoundResource<List<NewsArticles>, NewsSource>(appExecutors) {
            override fun saveCallResult(item: NewsSource) {
                if (!item.articles.isEmpty()) {
                    newsDao.deleteAllArticles()
                    newsDao.insertArticles(item.articles)
                }
            }

            override fun shouldFetch(data: List<NewsArticles>?) =
                (ConnectivityUtil.isConnected(context))

            override fun loadFromDb() = newsDao.getNewsArticles()

            override fun createCall() =
                apiServices.getNewsSource(data)

        }.asLiveData()
    }

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     * LiveData<Resource<NewsSource>>
     */
    fun getNewsArticlesFromServerOnly(countryShortKey: String):
            LiveData<Resource<NewsSource>> {

        val data = HashMap<String, String>()
        data["country"] = countryShortKey
        data["apiKey"] = BuildConfig.WEATHER_API_KEY

        return object : NetworkResource<NewsSource>() {
            override fun createCall(): LiveData<Resource<NewsSource>> {
                return apiServices.getNewsSource(data)
            }

        }.asLiveData()
    }

}