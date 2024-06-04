package com.example.financeapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.financeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*
    * Declaring general variables
    */
    //viewBind
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setups
        setupBindings()
        setupButtonAddTransaction()
    }

    private fun setupBindings() {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setupButtonAddTransaction() {

        binding.btnAddTransaction.setOnClickListener {
            val intent = Intent(this, BudgetSettingActivity::class.java)
            startActivity(intent)
        }
    }
}