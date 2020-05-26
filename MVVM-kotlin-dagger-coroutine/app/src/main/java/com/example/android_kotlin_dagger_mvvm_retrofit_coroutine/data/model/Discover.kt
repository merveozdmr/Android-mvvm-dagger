package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model

import java.io.Serializable

data class Discover(
    val type: String,
    val title: String,
    val featured: ArrayList<Featured>,
    val products: ArrayList<Products>,
    val categories: ArrayList<Categories>,
    val collections: ArrayList<Collections>,
    val editorShops: ArrayList<Shops>,
    val shops: ArrayList<Shops>
) : Serializable {
    override fun toString(): String {
        return "Title: $title"
    }
}