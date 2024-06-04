package com.example.financeapp.model.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.financeapp.utils.Constants.EXPENSE_TABLE

@Entity(
    tableName = EXPENSE_TABLE,
    foreignKeys = [ForeignKey(
        entity = Budget::class,
        parentColumns = ["id"],
        childColumns = ["budgetId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val category: String,
    val date: String,
    val budgetId: Int
)

