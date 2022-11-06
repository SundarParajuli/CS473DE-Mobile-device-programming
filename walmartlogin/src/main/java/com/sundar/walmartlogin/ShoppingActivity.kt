package com.sundar.walmartlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import com.sundar.walmartlogin.data.Product
import com.sundar.walmartlogin.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    lateinit var binding:ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        val bundle = intent.extras
        val username: String? = bundle?.getString("username")
        username?.let {email->
            binding.tvWelcomeMessage.text = getString(R.string.txt_welcome,email)
        }

        binding.cvBeauty.setOnClickListener {
            showToast("Beauty")
        }
        binding.cvClothing.setOnClickListener {
            showToast("Clothing")
        }
        binding.cvElectronic.setOnClickListener {
            val intent = Intent(this,ElectronicsListActivity::class.java)
            bundle?.let {
                intent.putExtras(it)
            }
            startActivity(intent)
            showToast("Electronic")
        }
        binding.cvFood.setOnClickListener {
            showToast("Food")
        }


    }

    private fun showToast(category: String) {
        Toast.makeText(this,"You have chosen the $category of shopping",Toast.LENGTH_SHORT).show()
    }

    private fun initViewBinding() {
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        this.title = "Shopping"
    }
}