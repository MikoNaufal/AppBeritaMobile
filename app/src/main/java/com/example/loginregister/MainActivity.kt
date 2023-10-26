package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        btnLoginListener()
        btnRegisterListener()
    }
    private fun btnLoginListener(){
        binding.btn1.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
    private fun btnRegisterListener(){
        binding.btn2.setOnClickListener{
            startActivity(Intent(this,Register::class.java))
        }
    }

}