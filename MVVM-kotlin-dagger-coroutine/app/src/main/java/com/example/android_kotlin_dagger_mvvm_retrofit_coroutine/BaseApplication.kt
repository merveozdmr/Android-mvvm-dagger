package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine

import android.app.Application
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.component.DaggerIAppComponent
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.component.IAppComponent

class BaseApplication: Application() {
    private lateinit var appComponent: IAppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerIAppComponent.builder().application(this).build()
    }

    fun getAppComponent(): IAppComponent{
        return appComponent
    }

}