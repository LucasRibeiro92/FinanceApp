package com.example.financeapp.model.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financeapp.utils.Constants.TRANSACTION_TABLE

@Entity(tableName = TRANSACTION_TABLE)
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var name: String,
    var amount: Double,
    var type: Int, //Here we gonna have 2 = Income and 3 = Expense
    var category: String,
    var date: String,
    var budgetId: Int
)
