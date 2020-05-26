package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model

import java.io.Serializable

data class Shops(
    val id: Int,
    val name: String,
    val slug: String,
    val definition: String,
    val name_updateable: Boolean,
    val vacation_mode: Int,
    val created_at: String,
    val shop_payment_id: Int,
    val product_count: Int,
    val popular_products: ArrayList<Popular_products>?,
    val shop_rate: Int,
    val comment_count: Int,
    val follower_count: Int,
    val is_editor_choice: Boolean,
    val is_following: Boolean,
    val cover: Cover?,
    val share_url: String,
    val logo: Logo?
) : Serializable