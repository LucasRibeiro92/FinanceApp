package com.example.financeapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.financeapp.R
import com.example.financeapp.databinding.ActivityViewReportBinding
import com.example.financeapp.model.data.local.entity.Transaction
import com.example.financeapp.ui.viewmodel.TransactionViewModel
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewReportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewReportBinding
    private val transactionViewModel: TransactionViewModel by viewModel()

    //MYTAG
    private val TAG: String = "BUDGET_TEST"

    private var totalExpenses: Double? = 0.0
    private var totalIncomes: Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Setup
        setupBindings()
        setupBackButton()
        setupPieChart()
        setupBarChart()
        observeTransactions()
    }

    private fun setupBindings() {

        binding = ActivityViewReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setupBackButton() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupValues(transactions: List<Transaction>) {
        transactions.forEach { transaction ->
            if (transaction.type == "Expense") {
                totalExpenses = totalExpenses?.plus(transaction.amount)
                Log.d("$TAG", "Expense: $totalExpenses")
            } else {
                totalIncomes = totalIncomes?.plus(transaction.amount)
                Log.d("$TAG", "Income: $totalExpenses")
            }
        }
    }

    private fun setupPieChart() {
        binding.pieChart.description.isEnabled = false
        binding.pieChart.isDrawHoleEnabled = true
        binding.pieChart.setHoleColor(android.R.color.transparent)
        binding.pieChart.setUsePercentValues(true)
        binding.pieChart.setEntryLabelColor(android.R.color.black)
    }

    private fun setupBarChart() {
        binding.barChart.description.isEnabled = false
        binding.barChart.setDrawBarShadow(false)
        binding.barChart.setDrawValueAboveBar(true)
        binding.barChart.setPinchZoom(true)
        binding.barChart.setDrawGridBackground(false)
    }

    private fun observeTransactions() {
        transactionViewModel.allTransactions.observe(this) { transactions ->
            transactions?.let {
                updatePieChart(it)
                updateBarChart(it)
                setupValues(it)
            }
        }
    }

    private fun updatePieChart(transactions: List<Transaction>) {
        val entries = mutableListOf<PieEntry>()

        transactions.forEach { transaction ->
            val label = if (transaction.type == "Expense") "Despesas" else "Receitas"
            entries.add(PieEntry(transaction.amount.toFloat(), "${transaction.category} ($label)"))
        }

        val dataSet = PieDataSet(entries, "Transações")
        dataSet.colors = listOf(
            getColor(R.color.myred), // Color for expenses
            getColor(R.color.mygreen) // Color for incomes
        )

        val pieData = PieData(dataSet)
        binding.pieChart.data = pieData
        binding.pieChart.invalidate() // Refresh the chart
    }

    private fun updateBarChart(transactions: List<Transaction>) {
        val expenseMap = mutableMapOf<String, Float>()

        transactions.forEach { transaction ->
            if (transaction.type == "Expense") {
                val currentAmount = expenseMap[transaction.category] ?: 0f
                expenseMap[transaction.category] = currentAmount + transaction.amount.toFloat()
            }
        }

        val barEntries = mutableListOf<BarEntry>()
        var index = 0f
        for ((category, amount) in expenseMap) {
            barEntries.add(BarEntry(index, amount))
            index++
        }

        val barDataSet = BarDataSet(barEntries, "Gastos por Categoria")
        barDataSet.colors = listOf(getColor(R.color.myred))
        val barData = BarData(barDataSet)

        binding.barChart.data = barData
        binding.barChart.invalidate() // Refresh the chart
    }
}