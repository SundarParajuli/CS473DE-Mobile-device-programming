package com.sundar.walmartlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sundar.walmartlogin.data.User
import com.sundar.walmartlogin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding:ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        binding.btnCreateAccount.setOnClickListener {
            isViewValid()
            Toast.makeText(this,"Account created successfully",Toast.LENGTH_SHORT).show()
        }
    }

    private fun isViewValid() {
        val fName= binding.etFirstName.text.toString()
        val lName= binding.etLastName.text.toString()
        val eAddress= binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        if (fName.isNotBlank() && lName.isNotBlank() && eAddress.isNotBlank() && password.isNotBlank()){
            val user = User(fName,lName,eAddress,password)
            val bundle = Bundle()
            bundle.putParcelable("user",user)
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun initViewBinding() {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}