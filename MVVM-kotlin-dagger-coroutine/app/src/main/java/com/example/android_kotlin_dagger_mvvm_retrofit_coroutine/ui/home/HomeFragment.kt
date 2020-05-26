package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.BaseApplication
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.R
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.databinding.FragmentHomeBinding
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.adapters.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity!!.application as BaseApplication).getAppComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.isLoading().observe(viewLifecycleOwner, Observer {
            if(it) {
                binding.layoutHomeScroll.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.layoutHomeScroll.visibility = View.VISIBLE
            }
        })
        homeViewModel.getCategories().observe(viewLifecycleOwner, Observer {
            if (!(it.isNullOrEmpty())) {
                binding.recyclerCategory.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.recyclerCategory.adapter = CategoriesRecyclerViewAdapter(it)
            }
        })
        homeViewModel.getProducts().observe(viewLifecycleOwner, Observer {
            if (!(it.isNullOrEmpty())) {
                binding.recyclerProduct.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.recyclerProduct.adapter = ProductRecyclerViewAdapter(it)
            }
        })
        homeViewModel.getShops().observe(viewLifecycleOwner, Observer {
            if (!(it.isNullOrEmpty())) {
                binding.recyclerShops.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.recyclerShops.adapter = ShopsRecyclerViewAdapter(it)
            }
        })
        homeViewModel.getCollections().observe(viewLifecycleOwner, Observer {
            if (!(it.isNullOrEmpty())) {
                binding.recyclerCollection.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.recyclerCollection.adapter = CollectionsRecyclerViewAdapter(it)
            }
        })
        homeViewModel.getFeatured().observe(viewLifecycleOwner, Observer {
            if (!(it.isNullOrEmpty())) {
                val screenPageLimit = it.size
                val featuredPagerAdapter = FeaturedPagerAdapter(
                    it,
                    R.layout.item_featured_detail,
                    screenPageLimit
                )
                binding.layoutFeaturedIndicator.init(screenPageLimit)
                binding.pagerFeatured.adapter = featuredPagerAdapter
                binding.pagerFeatured.setPageTransformer(false, featuredPagerAdapter)
                binding.pagerFeatured.offscreenPageLimit = screenPageLimit
                binding.pagerFeatured.pageMargin = 0
            }

            binding.pagerFeatured.addOnPageChangeListener(object :
                ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    binding.layoutFeaturedIndicator.setSelected(position)
                }
            })
        })
        homeViewModel.getDiscover().observe(viewLifecycleOwner, Observer {
            binding.viewModel = homeViewModel
            binding.executePendingBindings()
        })
    }
}