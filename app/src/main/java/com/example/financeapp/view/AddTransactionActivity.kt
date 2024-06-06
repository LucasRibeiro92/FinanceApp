package com.example.financeapp.view

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.financeapp.databinding.ActivityAddTransactionBinding
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.model.data.local.entity.Transaction
import com.example.financeapp.viewmodel.BudgetViewModel
import com.example.financeapp.viewmodel.TransactionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTransactionBinding
    private val transactionViewModel: TransactionViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setups
        setupBindings()
        setupBackButton()
        setupDatePickerButton()
        setupCategorySpinner()
        setupSaveButton()
    }

    private fun setupBindings() {
        binding = ActivityAddTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupBackButton() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
    private fun setupDatePickerButton() {
        binding.btnDatePicker.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.tvSelectedDate.text = selectedDate
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    private fun setupCategorySpinner() {
        // Lista predefinida de categorias
        val categories = listOf("Health", "Food", "Transportation", "Entertainment", "Utilities", "Other")

        // Cria um ArrayAdapter usando a lista de categorias
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Configura o Spinner com o ArrayAdapter
        binding.spinnerCategory.adapter = adapter
    }

    private fun setupSaveButton() {
        binding.btnSave.setOnClickListener {

            val transactionAmount = binding.etTransactionAmount.text.toString().toDoubleOrNull()
            val transactionCategory = binding.spinnerCategory.selectedItem.toString()
            val transactionDate = binding.tvSelectedDate.text.toString()

            if (transactionAmount == null) {
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val transactionType = if (binding.rbExpense.isChecked) {
                "Expense"
            } else if (binding.rbIncome.isChecked) {
                "Income"
            } else {
                Toast.makeText(this, "Select a transaction type", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val transaction = Transaction(
                amount = transactionAmount,
                category = transactionCategory,
                date = transactionDate,
                type = transactionType
            )

            transactionViewModel.insertTransaction(transaction)
            Toast.makeText(this, "$transactionType saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}