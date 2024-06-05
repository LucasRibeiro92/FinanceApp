package com.example.financeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.model.repository.BudgetRepository
import kotlinx.coroutines.launch

class BudgetViewModel(
    private val repository: BudgetRepository
) : ViewModel() {

    private val _budgets = MutableLiveData<List<Budget>>()
    val budgets: LiveData<List<Budget>> get() = _budgets

    init {
        getAllBudgets()
    }

    fun getAllBudgets(): LiveData<List<Budget>> {
        return repository.allBudgets
    }

    fun insertBudget(budget: Budget) = viewModelScope.launch {
        repository.insertBudget(budget)
    }
}