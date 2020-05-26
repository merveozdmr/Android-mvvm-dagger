package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.*
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.domain.usecase.IExploreUseCase
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.helper.DiscoverType
import kotlinx.coroutines.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val iExploreUseCase: IExploreUseCase) :
    ViewModel() {
    private lateinit var job: Job

    private var discoverListLiveData = MutableLiveData<ArrayList<Discover>>()
    private var featuredListLiveData: MutableLiveData<ArrayList<Featured>> = MutableLiveData()
    private var productListLiveData: MutableLiveData<ArrayList<Products>> = MutableLiveData()
    private var shopListLiveData: MutableLiveData<ArrayList<Shops>> = MutableLiveData()
    private var collectionListLiveData: MutableLiveData<ArrayList<Collections>> = MutableLiveData()
    private var categoryListLiveData: MutableLiveData<ArrayList<Categories>> = MutableLiveData()

    private var isLoadingLiveData = MutableLiveData<Boolean>()

    fun getDiscover(): MutableLiveData<ArrayList<Discover>> {
        if (discoverListLiveData.value == null) {
            callData()
        }
        return discoverListLiveData
    }

    fun getDiscoverTitle(type: Int): String? {
        return discoverListLiveData.value?.get(type)?.title
    }

    fun getFeatured(): MutableLiveData<ArrayList<Featured>> {
        return featuredListLiveData
    }

    fun getProducts(): MutableLiveData<ArrayList<Products>> {
        return productListLiveData
    }

    fun getShops(): MutableLiveData<ArrayList<Shops>> {
        return shopListLiveData
    }

    fun getCollections(): MutableLiveData<ArrayList<Collections>> {
        return collectionListLiveData
    }

    fun getCategories(): MutableLiveData<ArrayList<Categories>> {
        return categoryListLiveData
    }

    fun isLoading(): MutableLiveData<Boolean>{
        return isLoadingLiveData
    }

    private fun callData() {
        isLoadingLiveData.value = true
        job = Job()
        job = CoroutineScope(Dispatchers.IO + job).launch {
            withContext(Dispatchers.Main){
                val discoverData = iExploreUseCase.getData()
                if (!discoverData.isNullOrEmpty()) {
                    discoverListLiveData.value = discoverData
                    for (list in discoverData) {
                        when (list.type) {
                            DiscoverType.FEATURED.type -> featuredListLiveData.value = list.featured
                            DiscoverType.PRODUCTS.type -> productListLiveData.value = list.products
                            DiscoverType.CATEGORIES.type -> categoryListLiveData.value = list.categories
                            DiscoverType.COLLECTIONS.type -> collectionListLiveData.value = list.collections
                            DiscoverType.SHOPS.type -> shopListLiveData.value = list.shops
                        }
                    }

                }
                isLoadingLiveData.value = false
            }
        }
    }
}