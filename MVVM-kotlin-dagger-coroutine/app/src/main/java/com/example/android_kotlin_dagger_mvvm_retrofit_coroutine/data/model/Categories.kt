package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model

import java.io.Serializable

data class Categories(
    val id: Int,
    val name: String,
    val parent_id: String?,
    val order: Int,
    val parent_category: String?,
    val logo: Logo,
    val cover: Cover,
    val children: ArrayList<Children>
) : Serializable