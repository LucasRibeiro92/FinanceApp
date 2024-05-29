package com.example.financeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.model.data.local.entity.Income
import com.example.financeapp.model.repository.IncomeRepository
import kotlinx.coroutines.launch

class IncomeViewModel(private val repository: IncomeRepository) : ViewModel() {

    val allIncome: LiveData<List<Income>> = repository.allIncome

    fun insertIncome(income: Income) = viewModelScope.launch {
        repository.insertIncome(income)
    }
}