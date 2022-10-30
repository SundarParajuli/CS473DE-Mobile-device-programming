package com.sundar.dinnerdecider

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sundar.dinnerdecider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var foodArray = arrayListOf("Hamburger","Pizza","Mexican","American","Chinese")
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        initDecideClickListener()
        binding.btnAddFood.setOnClickListener {
            handleAddFood()
        }
        binding.etAddNewFood.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                handleAddFood()
                hideKeyboard()
                return@setOnEditorActionListener true
            }
            false
        }
    }

    private fun hideKeyboard() {
        this.currentFocus?.let { view ->
            val imm = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun initDecideClickListener() {
        binding.btnDecide.setOnClickListener {
            binding.tvFood.text = foodArray.random()
        }
    }

    private fun handleAddFood() {
        val foodFromUserInput: String = binding.etAddNewFood.text.toString()
        if (foodFromUserInput.isNotBlank()) {
            foodArray.add(foodFromUserInput)
            binding.etAddNewFood.text.clear()
        } else {
            Toast.makeText(this, "Please add your desired food", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}