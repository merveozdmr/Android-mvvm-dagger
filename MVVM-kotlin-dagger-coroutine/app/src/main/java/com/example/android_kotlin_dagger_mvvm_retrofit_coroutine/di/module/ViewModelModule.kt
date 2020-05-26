package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.di.key.ViewModelKey
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.ViewModelFactory
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindTodoViewModel(homeViewModel: HomeViewModel): ViewModel
}