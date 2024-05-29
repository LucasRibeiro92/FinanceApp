package com.example.financeapp.model.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.financeapp.model.data.local.entity.Expense
import com.example.financeapp.utils.Constants.EXPENSE_TABLE

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM $EXPENSE_TABLE")
    fun getAllExpenses(): LiveData<List<Expense>>
}
