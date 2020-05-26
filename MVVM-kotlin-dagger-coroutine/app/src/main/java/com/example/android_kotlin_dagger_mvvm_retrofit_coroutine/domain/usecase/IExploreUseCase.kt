package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.usecase

import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Discover
import kotlinx.coroutines.Deferred

interface IExploreUseCase {
    suspend fun getData(): ArrayList<Discover>
}