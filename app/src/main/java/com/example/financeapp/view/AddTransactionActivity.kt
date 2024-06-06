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
import com.example.financeapp.viewmodel.BudgetViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTransactionBinding
    private val budgetViewModel: BudgetViewModel by viewModel()
    private val expenseViewModel: ExpenseViewModel by viewModel()
    private val incomeViewModel: IncomeViewModel by viewModel()

    private lateinit var budgetIds: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindings()
        setupBackButton()
        setupDatePickerButton()
        setupCategorySpinner()

        // Observe the budgets and populate the spinner
        budgetViewModel.getAllBudgets().observe(this, Observer { budgets ->
            populateBudgetSpinner(budgets)
        })

        //Setup save button
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
        val categories = listOf("Food", "Transportation", "Entertainment", "Utilities", "Other")

        // Cria um ArrayAdapter usando a lista de categorias
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Configura o Spinner com o ArrayAdapter
        binding.spinnerCategory.adapter = adapter
    }

    private fun populateBudgetSpinner(budgets: List<Budget>) {
        val budgetNames = budgets.map { it.name }
        budgetIds = budgets.map { it.id }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, budgetNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBudget.adapter = adapter
    }

    private fun setupSaveButton() {
        binding.btnSave.setOnClickListener {

            val transactionName = binding.etTransactionName.text.toString()
            val transactionAmount = binding.etTransactionAmount.text.toString().toDoubleOrNull()
            val transactionCategory = binding.spinnerCategory.selectedItem.toString()
            val transactionDate = binding.tvSelectedDate.text.toString()
            val transactionBudgetPosition = binding.spinnerBudget.selectedItemPosition
            val transactionBudgetId = budgetIds[transactionBudgetPosition]

            if (transactionAmount == null) {
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (binding.rbExpense.isChecked) {
                val expense = Expense(
                    name = transactionName,
                    amount = transactionAmount,
                    category = transactionCategory,
                    date = transactionDate,
                    budgetId = transactionBudgetId
                )
                expenseViewModel.insertExpense(expense)
                Toast.makeText(this, "Expense saved", Toast.LENGTH_SHORT).show()
                finish()
            } else if (binding.rbIncome.isChecked) {
                val income = Income(
                    name = transactionName,
                    amount = transactionAmount,
                    category = transactionCategory,
                    date = transactionDate,
                    budgetId = transactionBudgetId
                )
                incomeViewModel.insertIncome(income)
                Toast.makeText(this, "Income saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Select a transaction type", Toast.LENGTH_SHORT).show()
            }
        }
    }
}