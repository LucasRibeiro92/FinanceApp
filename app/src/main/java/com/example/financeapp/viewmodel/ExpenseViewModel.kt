package com.example.financeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.model.data.local.entity.Expense
import kotlinx.coroutines.launch

class ExpenseViewModel(private val repository: ExpenseRepository) : ViewModel() {

    val allExpenses: LiveData<List<Expense>> = repository.allExpenses

    fun insertExpense(expense: Expense) = viewModelScope.launch {
        repository.insertExpense(expense)
    }
}