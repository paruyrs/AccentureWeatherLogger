package com.accenture.accentureweatherlogger.mvvm.ui.weather

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.accenture.accentureweatherlogger.mvvm.R
import com.accenture.accentureweatherlogger.mvvm.di.base.Injectable
import com.accenture.accentureweatherlogger.mvvm.di.base.ViewModelFactory
import com.accenture.accentureweatherlogger.mvvm.repository.model.weather.WeatherData
import com.accenture.accentureweatherlogger.mvvm.ui.BaseActivity
import com.accenture.accentureweatherlogger.mvvm.ui.countries.CountriesViewModel
import com.accenture.accentureweatherlogger.mvvm.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.layout_weather_info.*
import javax.inject.Inject

class WeatherActivity : BaseActivity(), Injectable {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var viewModel: WeatherInfoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        // initialize ViewModel
        viewModel = ViewModelProvider(this, factory).get(WeatherInfoViewModel::class.java)

        layout_weather_basic.visibility = View.INVISIBLE
        // View Weather button click listener
        btn_get_weather.setOnClickListener {
               viewModel.getWeatherInfo("5056033") // fetch weather info
        }





    }

    private val weatherInfoViewModel by lazy {
        getViewModel<WeatherInfoViewModel>()
    }




    private fun setWeatherInfo(weatherData: WeatherData) {
        layout_weather_basic.visibility = View.VISIBLE
        date_time?.text = weatherData.dateTime
        temperature?.text = weatherData.temperature
        city_country?.text = weatherData.cityAndCountry
    }

}






