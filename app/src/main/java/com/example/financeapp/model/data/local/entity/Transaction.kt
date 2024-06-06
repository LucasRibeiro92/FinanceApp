package com.example.financeapp.model.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financeapp.utils.Constants.TRANSACTION_TABLE

@Entity(tableName = TRANSACTION_TABLE)
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var amount: Double,
    var type: String,
    var category: String,
    var date: String
)
