package com.sundar.walmartlogin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sundar.walmartlogin.adapter.ProductAdapter
import com.sundar.walmartlogin.data.Product
import com.sundar.walmartlogin.databinding.ActivityElectronicsListBinding
import java.util.ArrayList

class ElectronicsListActivity : AppCompatActivity() {
    private lateinit var binding:ActivityElectronicsListBinding
    private  var productList:ArrayList<Product>? = arrayListOf()
    private lateinit var productAdapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        productList = bundle?.getParcelableArrayList("product")
        initViewBinding()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        this.productAdapter = ProductAdapter(onItemClick = {
            val bundle = Bundle()
            bundle.putParcelable("product",it)
            val intent = Intent(this,ProductDetailActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        })
        productAdapter.submitList(productList?.toMutableList())

        binding.rvElectronic.apply {
            this.layoutManager = LinearLayoutManager(this@ElectronicsListActivity)
            this.adapter = productAdapter
        }
    }

    private fun initViewBinding(){
        binding = ActivityElectronicsListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        this.title = "Product List"
    }
}