package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.module

import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.repository.ExploreRepository
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.usecase.ExploreUseCase
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.usecase.IExploreUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCase(repository: ExploreRepository): IExploreUseCase {
        return ExploreUseCase(repository)
    }
}