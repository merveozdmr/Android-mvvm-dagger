package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model

import java.io.Serializable

data class Featured(
    val id: Int,
    val type: String,
    val cover: Cover,
    val title: String,
    val sub_title: String
) : Serializable