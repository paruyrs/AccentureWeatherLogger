package com.accenture.accentureweatherlogger.mvvm.di.modules

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.accenture.accentureweatherlogger.mvvm.BuildConfig
import com.accenture.accentureweatherlogger.mvvm.app.App
import com.accenture.accentureweatherlogger.mvvm.repository.api.ApiServices
import com.accenture.accentureweatherlogger.mvvm.repository.api.network.LiveDataCallAdapterFactoryForRetrofit
import com.accenture.accentureweatherlogger.mvvm.repository.db.AppDatabase
import com.accenture.accentureweatherlogger.mvvm.repository.db.countries.CountriesDao
import com.accenture.accentureweatherlogger.mvvm.repository.db.news.NewsArticlesDao
import com.accenture.accentureweatherlogger.mvvm.repository.db.weather.WeatherDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Waheed on 04,November,2019
 */

@Module(includes = [PrefrencesModule::class, ActivityModule::class, ViewModelModule::class])
class AppModule {

    /**
     * Static variables to hold base url's etc.
     */
    companion object {
        private const val BASE_URL = BuildConfig.BASE_URL
    }


    /**
     * Provides ApiServices client for Retrofit
     */
    @Singleton
    @Provides
    fun provideNewsService(): ApiServices {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactoryForRetrofit())
            .build()
            .create(ApiServices::class.java)
    }


    /**
     * Provides app AppDatabase
     */
    @Singleton
    @Provides
    fun provideDb(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "weather-db").build()
    }


    /**
     * Provides NewsArticlesDao an object to access NewsArticles table from Database
     */
    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): NewsArticlesDao {
        return db.newsArticlesDao()
    }

    /**
     * Provides CountriesDao an object to access Countries table from Database
     */
    @Singleton
    @Provides
    fun provideCountriesDao(db: AppDatabase): CountriesDao {
        return db.countriesDao()
    }

    /**
     * Provides WeatherDao an object to access Weather table from Database
     */
    @Singleton
    @Provides
    fun provideWeatherDao(db: AppDatabase): WeatherDao {
        return db.weatherDao()
    }


    /**
     * Application application level context.
     */
    @Singleton
    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }


    /**
     * Application resource provider, so that we can get the Drawable, Color, String etc at runtime
     */
    @Provides
    @Singleton
    fun providesResources(application: App): Resources = application.resources
}
