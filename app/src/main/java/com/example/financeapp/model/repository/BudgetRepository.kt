package com.example.financeapp.model.repository

import androidx.lifecycle.LiveData
import com.example.financeapp.model.data.local.dao.BudgetDao
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.utils.GeneralError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BudgetRepository(private val budgetDao: BudgetDao) {

    fun getBudget(): LiveData<Budget?> {
        return budgetDao.getBudget()
    }

    suspend fun insertBudget(budget: Budget) {
        withContext(Dispatchers.IO) {
            try {
                budgetDao.insertBudget(budget)
            } catch (e: Exception) {
                throw GeneralError.DatabaseError("Database operation failed: ${e.message}")
            }
        }
    }

    suspend fun updateBudget(budget: Budget) {
        withContext(Dispatchers.IO) {
            try {
                budgetDao.updateBudget(budget)
            } catch(e: Exception) {
                throw  GeneralError.DatabaseError("Database operation failed: ${e.message}")
            }
        }
    }

}