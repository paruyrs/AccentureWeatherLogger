package com.accenture.accentureweatherlogger.mvvm.repository.model.weather

import com.google.gson.annotations.SerializedName

data class WeatherSource(
    @SerializedName("coord")
    val coordinates: Coordinates = Coordinates(),
    @SerializedName("weather")
    val weather: List<Weather> = listOf(),
    @SerializedName("base")
    val base: String = "",
    @SerializedName("main")
    val main: Main = Main(),
    @SerializedName("visibility")
    val visibility: Int = 0,
    @SerializedName("dt")
    val dt: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("cod")
    val cod: Int = 0
)