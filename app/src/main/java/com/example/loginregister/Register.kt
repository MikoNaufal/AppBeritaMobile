package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.loginregister.databinding.ActivityRegisterBinding
import com.example.loginregister.db.AppDatabase
import com.example.loginregister.db.Regis
import kotlinx.coroutines.launch

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        txtLoginListener()
        btnBackListener()
    }

    private fun txtLoginListener() {
        binding.txtLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun btnBackListener() {
        binding.RBtn1.setOnClickListener {
        lifecycleScope.launch {
register()
        }

        }
    }

    suspend fun register() {
        val name = binding.edtFullname.text.toString()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        val user = Regis(0, name, email, password)

        val db = AppDatabase.getDatabase(this)
        val dao = db?.RegisDao()
        dao?.insertAll(user)
    }

}

