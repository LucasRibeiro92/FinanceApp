package com.example.financeapp.model.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financeapp.utils.Constants.EXPENSE_TABLE

@Entity(tableName = EXPENSE_TABLE)
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val category: String,
    val date: String
)

