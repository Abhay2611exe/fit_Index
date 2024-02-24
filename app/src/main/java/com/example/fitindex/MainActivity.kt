package com.example.fitindex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitindex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBMI.setOnClickListener {
        val intent = Intent(this@MainActivity,BMI_Moniter::class.java)
        startActivity(intent)
        }

        binding.btnUnderWeight.setOnClickListener {
            val intent = Intent(this,UnderWeight_Activity::class.java)
            startActivity(intent)
        }
    }
}