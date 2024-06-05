package com.example.financeapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.financeapp.databinding.ActivityBudgetSettingBinding
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.viewmodel.BudgetViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BudgetSettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBudgetSettingBinding
    private val budgetViewModel: BudgetViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setup
        setupBindings()
        setupSaveButton()
        setupBackButton()
    }

    private fun setupBindings() {
        binding = ActivityBudgetSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupSaveButton() {
        binding.btnSave.setOnClickListener {
            saveBudget()
        }
    }

    private fun saveBudget() {
        val budgetName = binding.etBudgetName.text.toString()
        val foodLimit = binding.etFoodLimit.text.toString().toDoubleOrNull()
        val transportLimit = binding.etTransportLimit.text.toString().toDoubleOrNull()
        val entertainmentLimit = binding.etEntertainmentLimit.text.toString().toDoubleOrNull()
        val utilitiesLimit = binding.etUtilitiesLimit.text.toString().toDoubleOrNull()
        val otherLimit = binding.etOtherLimit.text.toString().toDoubleOrNull()

        if (foodLimit == null || transportLimit == null || entertainmentLimit == null || utilitiesLimit == null || otherLimit == null) {
            Toast.makeText(this, "Please fill in all fields with valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val budget = Budget(
            name = budgetName,
            foodLimit = foodLimit,
            transportLimit = transportLimit,
            entertainmentLimit = entertainmentLimit,
            utilitiesLimit = utilitiesLimit,
            otherLimit = otherLimit
        )

        budgetViewModel.insertBudget(budget)
        Toast.makeText(this, "Budget saved", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun setupBackButton() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}