package com.sundar.walmartlogin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sundar.walmartlogin.data.User
import com.sundar.walmartlogin.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    var userList:ArrayList<User> = arrayListOf(
        User("Sundar","Parajuli","s@miu.edu","password"),
        User("Jimbe","Fishman","j@miu.edu","password"),
        User("Sanji","Kun","sa@miu.edu","password"),
        User("Luffy","Senpai","t@miu.edu","password")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        checkIntent()
        binding.btnLogin.setOnClickListener {
            if(validateViews()){
                navigateToShoppingActivity(binding.etEmail.text.toString())
            }
        }
        binding.btnCreateAccount.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.tvForgotPassword.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            if (email.isNotBlank()){
                for (user in userList){
                    if (email == user.userName){
                        emailUser(email, user)
                        break
                    }
                }
            }else{
                Toast.makeText(this,"Please enter your email",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun emailUser(email: String, user: User) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Password from walmart app")
        intent.putExtra(Intent.EXTRA_TEXT, "your passsword is ${user.password}")
        startActivity(intent)
    }

    private fun navigateToShoppingActivity(email:String) {
        val intent = Intent(this, ShoppingActivity::class.java)
        intent.putExtra("username", email)
        startActivity(intent)
    }

    private fun checkIntent() {
        val user: User? = intent.getParcelableExtra("user")
        user?.let {
            userList.add(it)
            navigateToShoppingActivity(it.userName)
        }
    }

    private fun validateViews(): Boolean{
        val username:String = binding.etEmail.text.toString()
        val password:String = binding.etPassword.text.toString()
        var isValidUser = false
        if (username.isNotBlank()&& password.isNotBlank()){
           for (user in userList){
               if (user.userName == username && user.password == password){
                   isValidUser = true
               }else{
                   Toast.makeText(this,"Wrong credentials please review",Toast.LENGTH_SHORT).show()
               }
           }
        }else{
            Toast.makeText(this,"Please enter both email and password",Toast.LENGTH_SHORT).show()
        }
        return isValidUser
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}