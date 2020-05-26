package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model

import java.io.Serializable

data class Images(
    val width: Int,
    val height: Int,
    val url: String,
    val medium: Medium,
    val thumbnail: Thumbnail
) : Serializable