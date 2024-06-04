package com.example.financeapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.financeapp.R
import com.example.financeapp.databinding.ActivityViewReportBinding

class ViewReportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setup
        setupBindings()
    }

    private fun setupBindings() {

        binding = ActivityViewReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}