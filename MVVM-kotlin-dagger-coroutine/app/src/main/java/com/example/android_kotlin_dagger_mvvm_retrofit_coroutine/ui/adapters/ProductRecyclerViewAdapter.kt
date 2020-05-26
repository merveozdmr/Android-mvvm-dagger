package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.R
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Products
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.databinding.ItemProductBinding

class ProductRecyclerViewAdapter(
    private val productList: ArrayList<Products>
) : RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemProductBinding: ItemProductBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_product,
            parent,
            false)
        return ViewHolder(itemProductBinding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(productList[position])
    }

    class ViewHolder(private var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(items: Products) {
            binding.products = items
        }
    }
}