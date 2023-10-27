package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.loginregister.databinding.ActivityLoginBinding
import db.AppDatabase
import db.Regis
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        btnBackLoginListener()
        txtRegisterListener()
    }
    private fun btnBackLoginListener(){
        lifecycleScope.launch {
            login()
        }
        startActivity(Intent(this,NewsActivity::class.java))
    }
    private fun txtRegisterListener(){
        binding.txtRegister.setOnClickListener{
            startActivity(Intent(this,Register::class.java))
        }
    }

    suspend fun login() {
        val db = AppDatabase.getDatabase(this)
        val dao = db?.RegisDao()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtConfPassword.text.toString()
        val getEmail = dao?.getEmail(email).toString()
        val getPassword = dao?.getPassword(password).toString()



        if (dao?.login(email, password) == true) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_LONG)
                .show()
        }
    }
}