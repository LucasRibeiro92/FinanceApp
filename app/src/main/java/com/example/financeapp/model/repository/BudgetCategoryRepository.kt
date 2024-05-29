package com.example.financeapp.model.repository

import androidx.lifecycle.LiveData
import com.example.financeapp.model.data.local.dao.BudgetCategoryDao
import com.example.financeapp.model.data.local.entity.BudgetCategory

class BudgetCategoryRepository(private val budgetCategoryDao: BudgetCategoryDao) {

    val allBudgetCategories: LiveData<List<BudgetCategory>> = budgetCategoryDao.getAllBudgetCategories()

    suspend fun insertBudgetCategory(budgetCategory: BudgetCategory) {
        budgetCategoryDao.insertBudgetCategory(budgetCategory)
    }

    fun getBudgetCategory(category: String): LiveData<BudgetCategory?> {
        return budgetCategoryDao.getBudgetCategory(category)
    }
}
