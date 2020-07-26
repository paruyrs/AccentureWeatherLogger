package com.accenture.accentureweatherlogger.mvvm.app

import android.app.Activity
import android.app.Application
import com.accenture.accentureweatherlogger.mvvm.di.base.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by Waheed on 04,November,2019
 */

class App : Application(), HasAndroidInjector  {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)
    }


    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}