package com.accenture.accentureweatherlogger.mvvm.repository.model.weather

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "main_table")
data class Main(
    @SerializedName("temp")
    val temp: Double = 0.0,
    @SerializedName("temp_min")
    val tempMin: Double = 0.0,
    @SerializedName("temp_max")
    val tempMax: Double = 0.0
)