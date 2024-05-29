package com.example.financeapp.model.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.financeapp.model.data.local.entity.Income
import com.example.financeapp.utils.Constants.INCOME_TABLE

@Dao
interface IncomeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIncome(income: Income)

    @Query("SELECT * FROM $INCOME_TABLE")
    fun getAllIncome(): LiveData<List<Income>>
}