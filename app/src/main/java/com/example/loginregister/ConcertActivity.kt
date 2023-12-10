package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.ActivityConcertBinding

class ConcertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConcertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityConcertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageNews.setOnClickListener{
            startActivity(Intent(this,NewsActivity::class.java))
        }
        binding.ilogout.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()

        }


    }
}