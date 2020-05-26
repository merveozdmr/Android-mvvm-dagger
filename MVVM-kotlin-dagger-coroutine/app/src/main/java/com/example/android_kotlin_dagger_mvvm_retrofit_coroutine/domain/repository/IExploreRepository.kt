package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.repository

import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Discover

interface IExploreRepository {
    suspend fun getData(): ArrayList<Discover>
}