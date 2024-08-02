package com.example.calculadoraimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvImcResult = findViewById<TextView>(R.id.tvImcResult)

        val imc: Float = intent.extras?.getFloat("IMC_Result") ?: 0f
        val imcFormatted = String.format("%.2f", imc)
        tvImcResult.text = "Tu IMC es: $imcFormatted"

    }
}
