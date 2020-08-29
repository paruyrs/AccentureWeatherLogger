package com.accenture.accentureweatherlogger.mvvm.repository.model.weather

data class WeatherData (
    var dateTime: String = "",
    var temperature: String = "0",
    var cityAndCountry: String = "",
    var weatherConditionIconUrl: String = "",
    var weatherConditionIconDescription: String = "",
    var sunrise: String = "",
    var sunset: String = ""
)