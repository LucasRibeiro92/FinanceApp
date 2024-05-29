package com.example.financeapp.model.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financeapp.utils.Constants.INCOME_TABLE

@Entity(tableName = INCOME_TABLE)
data class Income(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val category: String,
    val date: String
)

