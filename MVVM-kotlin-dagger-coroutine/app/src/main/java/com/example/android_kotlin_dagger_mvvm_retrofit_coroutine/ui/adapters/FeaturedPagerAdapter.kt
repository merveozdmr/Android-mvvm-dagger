package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.R
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Featured
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.databinding.ItemFeaturedDetailBinding
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.components.ScalableFrameLayout


class FeaturedPagerAdapter() : PagerAdapter(), ViewPager.PageTransformer {

    val BIG_SCALE = 1.5f
    private val SMALL_SCALE = 1.0f
    private var DIFF_SCALE = BIG_SCALE - SMALL_SCALE

    private lateinit var featuredPagerAdapter: ArrayList<Featured>
    private var layoutResAdapter = 0
    private var screenPageSize = 0
    private lateinit var itemFeaturedDetailBinding: ItemFeaturedDetailBinding

    constructor(
        featured: ArrayList<Featured>, @LayoutRes layoutRes: Int,
        screenPageLimit: Int
    ) : this() {
        this.featuredPagerAdapter = featured
        this.layoutResAdapter = layoutRes
        this.screenPageSize = screenPageLimit
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val context = container.context
        itemFeaturedDetailBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context), layoutResAdapter, container, false
        )

        val layout: ScalableFrameLayout = itemFeaturedDetailBinding.itemFeaturedDetail

        if (position == 0) layout.setScale(BIG_SCALE) else layout.setScale(SMALL_SCALE)

        val featuredModel = featuredPagerAdapter[position]
        itemFeaturedDetailBinding.featured = featuredModel

        container.addView(itemFeaturedDetailBinding.root)

        return itemFeaturedDetailBinding.root
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return screenPageSize
    }

    override fun transformPage(page: View, position: Float) {
        var scale = BIG_SCALE
        if (position > 0) {
            scale -= position * DIFF_SCALE
        } else {
            scale += position * DIFF_SCALE
        }

        if (scale < 0) {
            scale = 0f
        }

        (page.findViewById(R.id.item_featured_detail) as (ScalableFrameLayout)).setScale(scale)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View)
    }

}