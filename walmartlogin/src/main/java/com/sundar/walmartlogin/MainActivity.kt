package com.sundar.walmartlogin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sundar.walmartlogin.data.Product
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

    var productList:ArrayList<Product> = arrayListOf(
        Product("CC camera",100.00,"grey","https://thumbs.dreamstime.com/b/webcam-5859012.jpg","1","CCTV (Closed Circuit Television) is a closed system consisting of video cameras, display devices (monitors) and wired or wireless data networks that allow you to transfer images from video cameras to monitors."),
        Product("Wifi router",2000.00,"black","https://thumbs.dreamstime.com/b/wireless-router-5353948.jpg","2","A router is a physical or virtual appliance that passes information between two or more packet-switched computer networks. A router inspects a given data packet's destination Internet Protocol address (IP address), calculates the best way for it to reach its destination and then forwards it accordingly."),
        Product("webcam",120.00,"white","https://thumbs.dreamstime.com/b/webcam-5859012.jpg","3","A webcam is a digital video device commonly built into a computer. Its main function is to transmit pictures over the Internet. It is popularly used with instant messaging services and for recording images."),
        Product("Wifi router 2",1500.00,"blue","https://thumbs.dreamstime.com/b/wireless-router-23969781.jpg","4","A router is a physical or virtual appliance that passes information between two or more packet-switched computer networks. A router inspects a given data packet's destination Internet Protocol address (IP address), calculates the best way for it to reach its destination and then forwards it accordingly."),
        Product("Console",2500.00,"Black","https://thumbs.dreamstime.com/b/cable-modem-5887469.jpg","5","A video game console is an electronic device that outputs a video signal or image to display a video game that can be played with a game controller. These may be home consoles, which are generally placed in a permanent location connected to a television or other display devices and controlled with a separate game controller, or handheld consoles, which include their own display unit and controller functions built into the unit and which can be played anywhere. Hybrid consoles combine elements of both home and handheld consoles."),
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
        val bundle = Bundle()
        bundle.putParcelableArrayList("product",productList)
        bundle.putString("username", email)
        val intent = Intent(this, ShoppingActivity::class.java)
        intent.putExtras(bundle)
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
        val username:String = binding.etEmail.text.toString().trim()
        val password:String = binding.etPassword.text.toString().trim()
        var isValidUser = false
        if (username.isNotBlank()&& password.isNotBlank()){
           for (user in userList){
               if (user.userName == username && user.password == password){
                   isValidUser = true
                   break
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