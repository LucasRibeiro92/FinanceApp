package com.example.financeapp.model.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financeapp.utils.Constants.BUDGET_CATEGORY_TABLE

@Entity(tableName = BUDGET_CATEGORY_TABLE)
data class BudgetCategory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category: String,
    val limit: Double
)

