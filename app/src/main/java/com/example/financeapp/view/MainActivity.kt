package com.example.financeapp.view

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.financeapp.databinding.ActivityMainBinding
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.viewmodel.BudgetViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    /*
    * Declaring general variables
    */
    //viewBind
    private lateinit var binding: ActivityMainBinding
    private val budgetViewModel: BudgetViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setups
        setupBindings()
        setupButtons()

        // Observe the budgets and populate the spinner
        budgetViewModel.getAllBudgets().observe(this, Observer { budgets ->
            populateBudgetSpinner(budgets)
        })
    }

    private fun setupBindings() {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setupButtons() {
        binding.btnAddTransaction.setOnClickListener {
            val intent = Intent(this, AddTransactionActivity::class.java)
            startActivity(intent)
        }
        binding.btnAddBudget.setOnClickListener {
            val intent = Intent(this, BudgetSettingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun populateBudgetSpinner(budgets: List<Budget>) {
        val budgetNames = budgets.map { it.name }
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, budgetNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBudgets.adapter = adapter
    }
}