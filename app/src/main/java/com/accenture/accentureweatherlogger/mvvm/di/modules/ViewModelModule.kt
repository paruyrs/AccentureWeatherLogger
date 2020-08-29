package com.accenture.accentureweatherlogger.mvvm.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.accenture.accentureweatherlogger.mvvm.di.base.ViewModelFactory
import com.accenture.accentureweatherlogger.mvvm.di.base.ViewModelKey
import com.accenture.accentureweatherlogger.mvvm.ui.countries.CountriesViewModel
import com.accenture.accentureweatherlogger.mvvm.ui.news.NewsArticleViewModel
import com.accenture.accentureweatherlogger.mvvm.ui.weather.WeatherInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Waheed on 04,November,2019
 */

@Module
abstract class ViewModelModule {

    /**
     * Binding NewsArticleViewModel using this key "NewsArticleViewModel::class"
     * So you can get NewsArticleViewModel using "NewsArticleViewModel::class" key from factory
     */
    @Binds
    @IntoMap
    @ViewModelKey(NewsArticleViewModel::class)
    abstract fun bindNewsArticleViewModel(newsArticleViewModel: NewsArticleViewModel): ViewModel

    /**
     * Countries List View Model
     */
    @Binds
    @IntoMap
    @ViewModelKey(CountriesViewModel::class)
    abstract fun bindCountriesViewModel(countriesViewModel: CountriesViewModel): ViewModel

    /**
     * WeatherInfo View Model
     */
    @Binds
    @IntoMap
    @ViewModelKey(WeatherInfoViewModel::class)
    abstract fun bindWeatherInfoViewModel(weatherInfoViewModel: WeatherInfoViewModel): ViewModel



    /**
     * Binds ViewModels factory to provide ViewModels.
     */
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
