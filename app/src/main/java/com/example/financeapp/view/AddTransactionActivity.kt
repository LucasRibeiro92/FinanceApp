package com.example.financeapp.view

import android.app.DatePickerDialog
import android.icu.util.Calendar
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
        setupBackButton()
        setupDatePickerButton()
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
}