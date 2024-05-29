package com.example.financeapp.model.repository

import androidx.lifecycle.LiveData
import com.example.financeapp.model.data.local.dao.IncomeDao
import com.example.financeapp.model.data.local.entity.Income

class IncomeRepository(private val incomeDao: IncomeDao) {
    val allIncome: LiveData<List<Income>> = incomeDao.getAllIncome()

    suspend fun insertIncome(income: Income) {
        incomeDao.insertIncome(income)
    }
}