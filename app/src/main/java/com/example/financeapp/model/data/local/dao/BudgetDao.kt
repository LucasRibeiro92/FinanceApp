package com.example.financeapp.model.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.utils.Constants.BUDGET_TABLE

@Dao
interface BudgetDao {

    @Query("SELECT * FROM $BUDGET_TABLE LIMIT 1")
    fun getBudget(): LiveData<Budget?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBudget(budget: Budget)

    @Update
    fun updateBudget(budget: Budget)

}