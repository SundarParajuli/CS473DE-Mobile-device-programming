package com.sundar.walmartlogin.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sundar.walmartlogin.R
import com.sundar.walmartlogin.data.Product
import com.sundar.walmartlogin.databinding.ItemProductBinding

class ProductAdapter(var onItemClick: ((Product) -> Unit)?) : ListAdapter<Product, ProductAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =ItemProductBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.itemView.setOnClickListener { onItemClick?.let { it1 -> it1(currentItem) } }
    }

    inner class ViewHolder(private val binding:ItemProductBinding ) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(product: Product){
                Glide.with(binding.root.context).load(product.image).into(binding.ivProduct)
                binding.tvTitle.text= product.title
                binding.tvPrice.text= binding.root.context.getString(R.string.price_string,product.price)
                binding.tvColor.text=binding.root.context.getString(R.string.color_string,product.color)
            }
        }


    class DiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem:Product , newItem: Product) =
            oldItem.itemId == newItem.itemId

        override fun areContentsTheSame(oldItem: Product, newItem:Product ) =
            oldItem == newItem
    }
}