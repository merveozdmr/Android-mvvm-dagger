package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.R
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Categories
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.databinding.ItemCategoriesBinding

class CategoriesRecyclerViewAdapter(
    private val categoryList: ArrayList<Categories>
) : RecyclerView.Adapter<CategoriesRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemCategoriesBinding: ItemCategoriesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_categories,
            parent,
            false
        )
        return ViewHolder(itemCategoriesBinding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categoryList[position])
    }

    class ViewHolder(private var binding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(categories: Categories) {
            binding.categories = categories
            binding.executePendingBindings()
        }
    }
}