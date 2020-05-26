package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.R

class IndicatorLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private var dots: ArrayList<ImageView>? = null

    fun init(number: Int) {
        val context = context

        orientation = HORIZONTAL
        //dividerDrawable = ResourcesCompat.getDrawable(resources, R.drawable.indicator_divider, null)
        showDividers = SHOW_DIVIDER_MIDDLE
        gravity = Gravity.CENTER

        removeAllViews()

        dots = ArrayList(number)
        //val selectDotSize = (10 * (resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
        //val dotSize = (5 * (resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()

        for (i in 0 until number) {
            val imageView = ImageView(context)
            imageView.setImageResource(if (i == 0) R.drawable.dot_white else R.drawable.dot_gray)
            val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(16, 16, 16, 16)
            imageView.layoutParams = layoutParams

            //if (i == 0) imageView.layoutParams = LayoutParams(selectDotSize, selectDotSize)
            //else imageView.layoutParams = LayoutParams(dotSize, dotSize)
            dots?.add(imageView)
            addView(imageView)
        }
    }

    fun setSelected(position: Int) {
        if (!dots.isNullOrEmpty()) {
            val dotSize = dots?.size
            for (i in 0 until dotSize!!) {
                dots!!.get(i)
                    .setImageResource(if (i == position) R.drawable.dot_white else R.drawable.dot_gray)
            }
        }
    }
}