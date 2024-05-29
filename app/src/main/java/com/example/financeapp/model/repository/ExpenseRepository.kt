package com.example.financeapp.model.repository

import androidx.lifecycle.LiveData
import com.example.financeapp.model.data.local.dao.ExpenseDao
import com.example.financeapp.model.data.local.entity.Expense

class ExpenseRepository(private val expenseDao: ExpenseDao) {
    val allExpenses: LiveData<List<Expense>> = expenseDao.getAllExpenses()

    suspend fun insertExpense(expense: Expense) {
        expenseDao.insertExpense(expense)
    }
}