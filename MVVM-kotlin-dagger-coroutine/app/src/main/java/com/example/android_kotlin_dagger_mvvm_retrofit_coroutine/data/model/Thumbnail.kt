package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model

import java.io.Serializable

data class Thumbnail(
    val width: Int,
    val height: Int,
    val url: String
) : Serializable