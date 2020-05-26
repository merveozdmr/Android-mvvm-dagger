package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.module

import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.Service.IDataService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    private var baseUrl = "http://www.mocky.io/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideDataService(retrofit: Retrofit): IDataService {
        return retrofit.create(IDataService::class.java)
    }
}