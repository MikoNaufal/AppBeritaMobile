package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.loginregister.databinding.ActivityLoginBinding
import com.example.loginregister.db.AppDatabase
import com.example.loginregister.db.Regis
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()



        binding.LBtn1.setOnClickListener {
            lifecycleScope.launch {
                login()
            }

        }

        txtRegisterListener()
    }

    suspend fun login() {
        val db = AppDatabase.getDatabase(this)
        val dao = db?.RegisDao()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtConfPassword.text.toString()

        var userLoggedIn = false

        if (email.isNotEmpty() && password.isNotEmpty()) {
            userLoggedIn = dao!!.login(email, password)
        }
        if (userLoggedIn) {
            val intent = Intent(this,ConcertActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_LONG)
                .show()

        }
    }


    private fun txtRegisterListener() {
        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }

}
