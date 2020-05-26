package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.Service

import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Discover
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface IDataService {
    @GET("v2/5ecc1e613000008cd3dddb1b")
    fun getDiscovers(): Deferred<ArrayList<Discover>>
}