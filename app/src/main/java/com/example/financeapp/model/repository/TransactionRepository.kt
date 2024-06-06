package com.example.financeapp.model.repository

import androidx.lifecycle.LiveData
import com.example.financeapp.model.data.local.dao.BudgetDao
import com.example.financeapp.model.data.local.dao.TransactionDao
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.model.data.local.entity.Transaction
import com.example.financeapp.utils.GeneralError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransactionRepository(private val transactionDao: TransactionDao) {

    val allTransactions: LiveData<List<Transaction>> = transactionDao.getAllTransactions()

    suspend fun insertTransaction(transaction: Transaction) {
        withContext(Dispatchers.IO) {
            try {
                transactionDao.insertTransaction(transaction)
            }catch (e: Exception) {
                throw GeneralError.DatabaseError("Database operation failed: ${e.message}")
            }
        }
    }
}