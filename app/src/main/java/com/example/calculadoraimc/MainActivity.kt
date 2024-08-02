package com.example.calculadoraimc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    private lateinit var heightSlider:RangeSlider
    private lateinit var weightSlider:RangeSlider
    private lateinit var fabCalculate:FloatingActionButton

    private var height: Float = 30.00f
    private var weight: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()

    }

    private fun initComponents(){
        heightSlider = findViewById(R.id.heightSlider)
        weightSlider = findViewById(R.id.weightSlider)
        fabCalculate = findViewById(R.id.fabCalculate)

    }

    private fun initListeners(){
        heightSlider.addOnChangeListener { _, value, _ ->

            height = value.toFloat() / 100

        }

        weightSlider.addOnChangeListener { _, value, _ ->

            weight = value.toFloat()

        }

        fabCalculate.setOnClickListener {

            val height = height
            val weight = weight

            val imc = weight / (height * height)


            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("IMC_Result",imc)
            startActivity(intent)
        }
    }
}
