package com.example.financeapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.financeapp.R
import com.example.financeapp.databinding.ActivityAddTransactionBinding
import com.example.financeapp.databinding.ActivityMainBinding

class AddTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindings()
    }

    private fun setupBindings() {

        binding = ActivityAddTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}