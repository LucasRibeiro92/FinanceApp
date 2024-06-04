package com.example.financeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.model.repository.BudgetRepository
import kotlinx.coroutines.launch

class BudgetViewModel(
    private val repository: BudgetRepository
) : ViewModel() {

    val allBudgets: LiveData<List<Budget>> = repository.allBudgets

    fun insertBudget(budget: Budget) = viewModelScope.launch {
        repository.insertBudget(budget)
    }
}