package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.repository

import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Discover
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.Service.IDataService
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.repository.IExploreRepository
import kotlinx.coroutines.Deferred
import javax.inject.Inject


class ExploreRepository @Inject constructor(private var service: IDataService): IExploreRepository {
    override suspend fun getData(): ArrayList<Discover> {
        return service.getDiscovers().await()
    }

}