package com.sundar.tablayoutapplication

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.sundar.tablayoutapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        addTableRows()
        addTableRows("1.0","alpha")
        addTableRows("1.1","beta")
        binding.btnAddData.setOnClickListener {
            handleAddData()
        }
        binding.etAndroidCodeName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                handleAddData()
                hideKeyboard()
                return@setOnEditorActionListener true
            }
            false
        }
    }

    private fun handleAddData() {
        val versionName = binding.etAndroidVersion.text.toString()
        val codeName = binding.etAndroidCodeName.text.toString()
        if (versionName.isNotBlank() && codeName.isNotBlank()) {
            addTableRows(versionName, codeName)
            binding.etAndroidVersion.text.clear()
            binding.etAndroidCodeName.text.clear()
        }else{
            Toast.makeText(this, "Please enter the data", Toast.LENGTH_SHORT).show()
        }
    }

    private fun hideKeyboard() {
        this.currentFocus?.let { view ->
            val imm = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun addTableRows(version: String= "Version", codeName:String = "Code Name") {
        val tableRow = TableRow(this) // this
        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)
        layoutParams.span = 2
        tableRow.layoutParams = layoutParams

        val tvVersion = TextView(this)
        tvVersion.text = version
        tvVersion.setTextColor(resources.getColor(R.color.white,))
        tvVersion.background = AppCompatResources.getDrawable(this,R.color.purple_700)
        val tvVersionLayoutParams = TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0,3,3,0)
            weight = 1f
        }
        tvVersion.layoutParams = tvVersionLayoutParams




        val tvCodeName = TextView(this)
        tvCodeName.text = codeName
        tvCodeName.setTextColor(resources.getColor(R.color.white))
        tvCodeName.background = AppCompatResources.getDrawable(this,R.color.purple_700)
        val tvCodeNameLayoutParams = TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0,3,0,0)
            weight = 1f
        }
        tvCodeName.layoutParams = tvCodeNameLayoutParams



        tableRow.addView(tvVersion,0)
        tableRow.addView(tvCodeName,1)
        binding.tableLayout.addView(tableRow)
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}