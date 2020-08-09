package com.accenture.accentureweatherlogger.mvvm.repository.model.weather

import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lon")
    val lon: Double = 0.0,
    @SerializedName("lat")
    val lat: Double = 0.0
)