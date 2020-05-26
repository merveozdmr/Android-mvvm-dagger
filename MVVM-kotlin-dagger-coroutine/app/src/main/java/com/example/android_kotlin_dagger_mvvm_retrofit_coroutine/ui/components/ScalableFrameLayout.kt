package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.components

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.adapters.FeaturedPagerAdapter

class ScalableFrameLayout : FrameLayout {

    private var scale = FeaturedPagerAdapter().BIG_SCALE

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {
        setWillNotDraw(false)
    }

    fun setScale(scale: Float) {
        this.scale = scale
        this.invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        val w = this.width
        val h = this.height
        canvas?.scale(scale, scale, w / 2f, h / 2f)
        super.onDraw(canvas)
    }
}