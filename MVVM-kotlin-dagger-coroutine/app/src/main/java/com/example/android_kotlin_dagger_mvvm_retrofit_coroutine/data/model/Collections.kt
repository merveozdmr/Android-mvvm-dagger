package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model

import java.io.Serializable

data class Collections(
    val id: Int,
    val title: String,
    val definition: String,
    val start: String,
    val end: String?,
    val share_url: String,
    val cover: Cover,
    val logo: Logo
) : Serializable