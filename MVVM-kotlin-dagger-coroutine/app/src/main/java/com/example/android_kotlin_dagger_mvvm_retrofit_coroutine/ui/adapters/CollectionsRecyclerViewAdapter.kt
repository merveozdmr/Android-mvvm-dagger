package com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.R
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.data.model.Collections
import com.example.android_kotlin_dagger_mvvm_retrofit_coroutine.databinding.ItemCollectionsBinding

class CollectionsRecyclerViewAdapter(
    private val collectionList: ArrayList<Collections>
) : RecyclerView.Adapter<CollectionsRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemCollectionsBinding: ItemCollectionsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_collections,
            parent,
            false
        )
        return ViewHolder(itemCollectionsBinding)
    }

    override fun getItemCount(): Int {
        return collectionList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(collectionList[position])
    }

    class ViewHolder(private var binding: ItemCollectionsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(items: Collections) {
            binding.collections = items
        }
    }
}