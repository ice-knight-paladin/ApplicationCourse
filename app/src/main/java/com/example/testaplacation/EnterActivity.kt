package com.example.testaplacation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testaplacation.databinding.ActivityEnteryBinding

class EnterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnteryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnteryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnVK.setOnClickListener {
            val url = "https://vk.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Невозможно открыть ссылку", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnClassmates.setOnClickListener {
            val url = "https://ok.ru"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Невозможно открыть ссылку", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnEntry.setOnClickListener {
            startActivity(Intent(this@EnterActivity, MainActivity::class.java))
        }
    }
}