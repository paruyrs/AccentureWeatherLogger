package com.accenture.accentureweatherlogger.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by Waheed on 04,November,2019
 */

// Referring this class as BaseActivity

typealias BaseActivity = DaggerActivity

/**
 * Activity providing Dagger support and [ViewModel] support
 */
abstract class DaggerActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun androidInjector() = dispatchingAndroidInjector

}
