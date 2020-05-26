package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model

import java.io.Serializable

data class Products(
    val id: Int,
    val code: String?,
    val title: String,
    val slug: String,
    val definition: String,
    val old_price: String?,
    val price: String,
    val stock: Int,
    val max_installment: String?,
    val commission_rate: Int,
    val cargo_time: Int,
    val is_cargo_free: Boolean,
    val is_new: Boolean,
    val reject_reason: String?,
    val category_id: Int,
    val difference: String,
    val is_editor_choice: Boolean,
    val comment_count: Int,
    val is_owner: Boolean,
    val is_approved: Boolean,
    val is_active: Boolean,
    val share_url: String,
    val is_liked: Boolean,
    val like_count: Int,
    val shop: Shops?,
    val category: Category,
    val images: ArrayList<Images>
) : Serializable