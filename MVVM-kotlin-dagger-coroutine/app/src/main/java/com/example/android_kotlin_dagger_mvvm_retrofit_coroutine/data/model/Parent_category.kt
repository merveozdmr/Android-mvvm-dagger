package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model

import java.io.Serializable

data class Parent_category(
    val id: Int,
    val name: String,
    val parent_id: Int,
    val order: Int,
    val parent_category: String?
) : Serializable