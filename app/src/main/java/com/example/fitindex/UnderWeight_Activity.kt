package com.example.fitindex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitindex.databinding.ActivityUnderWeightBinding

class UnderWeight_Activity : AppCompatActivity() {
    lateinit var binding : ActivityUnderWeightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnderWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}