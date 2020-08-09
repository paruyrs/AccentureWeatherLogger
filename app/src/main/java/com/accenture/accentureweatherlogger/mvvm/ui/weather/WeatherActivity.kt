package com.accenture.accentureweatherlogger.mvvm.ui.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.accenture.accentureweatherlogger.mvvm.R

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
    }
}