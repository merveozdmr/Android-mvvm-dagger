package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.usecase

import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Discover
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.repository.IExploreRepository
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class ExploreUseCase @Inject constructor(private var repository: IExploreRepository) : IExploreUseCase {
    override suspend fun getData(): ArrayList<Discover> {
        return repository.getData()
    }
}