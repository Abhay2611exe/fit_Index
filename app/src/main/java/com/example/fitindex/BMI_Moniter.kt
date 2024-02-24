package com.example.fitindex

import android.annotation.SuppressLint
import android.graphics.Color
import android.nfc.FormatException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fitindex.databinding.ActivityBmiMoniterBinding

class BMI_Moniter : AppCompatActivity() {
    lateinit var binding : ActivityBmiMoniterBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FitIndex)
        binding = ActivityBmiMoniterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

         binding.btnCalculate.setOnClickListener {
             val user_age = binding.editAge.text.toString()
             val user_height = binding.editHeight.text.toString()
             val user_weight = binding.editWeight.text.toString()

             try {
                 if(user_age.isNotEmpty() && user_height.isNotEmpty() && user_weight.isNotEmpty())
                 {
                     val age = user_age.toInt()
                     val height = user_height.toInt() / 100.0
                     val weight = user_weight.toInt()
                     val result = weight/(height*height)

                     if (age > 6){
                         val formated_result = String.format("%.2f", result)
                         binding.textResult.text = "Your BMI is: $formated_result"

                         if (result < 13.3){
                                binding.textBMIResult.setTextColor(Color.BLUE)
                             binding.textBMIResult.text = "UNDER WEIGHT RANGE"
                         }
                         else if(result > 13.3 && result <= 18.2 ){
                             binding.textBMIResult.setTextColor(Color.GREEN)
                             binding.textBMIResult.text = "HEALTHY WEIGHT RANGE"
                         }
                         else if(result > 18.2 && result <= 33 ){
                             binding.textBMIResult.setTextColor(Color.LTGRAY)
                             binding.textBMIResult.text = "OVER WEIGHT RANGE"
                         }
                         else{
                             binding.textBMIResult.setTextColor(Color.RED)
                             binding.textBMIResult.text = "OVER WEIGHT RANGE"
                         }

                     }else {
                         Toast.makeText(this, "You are Under Age", Toast.LENGTH_LONG).show()
                     }
                 }else
                 {
                     Toast.makeText(this, "Fill the Detail first", Toast.LENGTH_SHORT).show()
                 }
             }catch (e: FormatException){
                 Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
             }
         }


    }
}