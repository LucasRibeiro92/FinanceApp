package com.example.financeapp.model.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.financeapp.utils.Constants.EXPENSE_TABLE

@Entity(
    tableName = EXPENSE_TABLE,
    foreignKeys = [ForeignKey(
        entity = BudgetCategory::class,
        parentColumns = ["id"],
        childColumns = ["budgetCategoryId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val category: String,
    val date: String,
    val budgetCategoryId: Int
)

