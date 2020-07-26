package com.accenture.accentureweatherlogger.mvvm.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.accenture.accentureweatherlogger.mvvm.repository.db.countries.CountriesDao
import com.accenture.accentureweatherlogger.mvvm.repository.db.news.NewsArticlesDao
import com.accenture.accentureweatherlogger.mvvm.repository.model.countries.Country
import com.accenture.accentureweatherlogger.mvvm.repository.model.news.NewsArticles

/**
 * Created by Waheed on 04,November,2019
 */

/**
 * App Database
 * Define all entities and access doa's here/ Each entity is a table.
 */
@Database(entities = [NewsArticles::class, Country::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Get DAO's
     */

    abstract fun newsArticlesDao(): NewsArticlesDao

    abstract fun countriesDao(): CountriesDao
}