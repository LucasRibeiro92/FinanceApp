package com.example.financeapp.model.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.financeapp.model.data.local.entity.BudgetCategory
import com.example.financeapp.utils.Constants.BUDGET_CATEGORY_TABLE

@Dao
interface BudgetCategoryDao {
    @Insert
    suspend fun insertBudgetCategory(budgetCategory: BudgetCategory)

    @Query("SELECT * FROM $BUDGET_CATEGORY_TABLE")
    fun getAllBudgetCategories(): LiveData<List<BudgetCategory>>

    @Query("SELECT * FROM $BUDGET_CATEGORY_TABLE WHERE category = :category LIMIT 1")
    fun getBudgetCategory(category: String): LiveData<BudgetCategory?>
}