package com.example.financeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.model.data.local.entity.BudgetCategory
import kotlinx.coroutines.launch

class BudgetCategoryViewModel(private val repository: BudgetCategoryRepository) : ViewModel() {

    val allBudgetCategories: LiveData<List<BudgetCategory>> = repository.allBudgetCategories

    fun insertBudgetCategory(budgetCategory: BudgetCategory) = viewModelScope.launch {
        repository.insertBudgetCategory(budgetCategory)
    }

    fun getBudgetCategory(category: String): LiveData<BudgetCategory?> {
        return repository.getBudgetCategory(category)
    }
}