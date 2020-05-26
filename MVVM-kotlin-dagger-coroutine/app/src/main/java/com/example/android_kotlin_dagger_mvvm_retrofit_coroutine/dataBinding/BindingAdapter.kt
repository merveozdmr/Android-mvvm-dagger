package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.dataBinding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["imageUrl", "imageWidth", "imageHeight"], requireAll = false)
fun loadImage(imageView: ImageView, imageUrl: String?, imageWidth: Int, imageHeight: Int) {
    if (!(imageUrl.isNullOrEmpty())) {
        Glide.with(imageView).load(imageUrl).override(imageWidth, imageHeight).centerCrop()
            .into(imageView)
    }
}

@BindingAdapter("android:text")
fun setText(textView: TextView, title: String?) {
    if (!title.isNullOrEmpty()) {
        textView.text = title
    }
}