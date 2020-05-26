package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.R
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Shops
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.databinding.ItemShopsBinding

class ShopsRecyclerViewAdapter(
    private val shopsList: ArrayList<Shops>
) : RecyclerView.Adapter<ShopsRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemShopsBinding: ItemShopsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_shops,
            parent,
            false)
        return ViewHolder(itemShopsBinding)
    }

    override fun getItemCount(): Int {
        return shopsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(shopsList[position])
    }

    class ViewHolder(private var binding: ItemShopsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(items: Shops) {
            binding.shops = items
        }
    }
}