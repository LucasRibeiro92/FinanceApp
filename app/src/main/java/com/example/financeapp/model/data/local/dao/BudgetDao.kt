package com.example.financeapp.model.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.utils.Constants.BUDGET_TABLE

@Dao
interface BudgetDao {
    @Insert
    fun insertBudget(budget: Budget)

    @Query("SELECT * FROM $BUDGET_TABLE")
    fun getAllBudgets(): LiveData<List<Budget>>
}