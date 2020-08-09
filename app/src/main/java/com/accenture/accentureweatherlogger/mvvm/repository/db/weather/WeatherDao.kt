package com.accenture.accentureweatherlogger.mvvm.repository.db.weather

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.accenture.accentureweatherlogger.mvvm.repository.model.weather.Main

@Dao
interface WeatherDao {

    /**
     * Insert weather into the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(articles: Main): Long

    /**
     * Get all the articles from database
     */
    @Query("SELECT * FROM main_table")
    fun getWeather(): LiveData<Main>

    @Query("DELETE FROM main_table")
    abstract fun deleteAllWeathers()
}