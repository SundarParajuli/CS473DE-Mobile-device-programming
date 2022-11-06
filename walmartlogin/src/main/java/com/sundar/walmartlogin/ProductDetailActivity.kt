package com.sundar.walmartlogin

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sundar.walmartlogin.data.Product
import com.sundar.walmartlogin.databinding.ActivityProductDetailBinding


class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    private var product:Product? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = intent.extras?.getParcelable("product")
        initViewBinding()
        inflateView()
    }

    private fun inflateView() {
        product?.let {
            Glide.with(binding.root.context).load(it.image).into(binding.ivProduct)
            binding.tvTitle.text = it.title
            binding.tvColor.text = getString(R.string.color_string,it.color)
            binding.tvPrice.text = getString(R.string.price_string,it.price)
            binding.tvDesc.text = getString(R.string.item_description,it.desc)
            binding.tvItemID.text = getString(R.string.walmart_id,it.itemId)
        }
    }

    private fun initViewBinding() {
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
            this.title = "Product Detail"
    }
}