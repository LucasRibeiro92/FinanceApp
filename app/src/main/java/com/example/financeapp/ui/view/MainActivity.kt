package com.example.financeapp.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.financeapp.databinding.ActivityMainBinding
import com.example.financeapp.ui.adapter.TransactionAdapter
import com.example.financeapp.ui.viewmodel.BudgetViewModel
import com.example.financeapp.ui.viewmodel.TransactionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    /*
    * Declaring general variables
    */
    private lateinit var binding: ActivityMainBinding
    private val budgetViewModel: BudgetViewModel by viewModel()
    private val transactionViewModel: TransactionViewModel by viewModel()
    //Adapter to feed RV
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setups
        setupBindings()
        setupRecyclerView()
        setupButtons()
        observeViewModel()
    }

    private fun setupBindings() {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvTransactionList.layoutManager = layoutManager
        transactionAdapter = TransactionAdapter(
            emptyList()
        )
        binding.rvTransactionList.adapter = transactionAdapter
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

    private fun observeViewModel() {
        transactionViewModel.transaction.observe(this) { transaction ->
            transaction?.let {
                transactionAdapter.updateTransactions(it)
            }
        }
    }

}