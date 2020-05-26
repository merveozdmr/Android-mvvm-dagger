package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.component

import android.app.Application
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.module.RetrofitModule
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.module.UseCaseModule
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.module.ViewModelModule
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, RetrofitModule::class, UseCaseModule::class])
interface IAppComponent {
    fun inject(fragment: HomeFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): IAppComponent
    }
}