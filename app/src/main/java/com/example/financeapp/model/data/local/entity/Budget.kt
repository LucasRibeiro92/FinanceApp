package com.example.financeapp.model.data.local.entity

import android.text.Editable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.financeapp.utils.Constants.BUDGET_TABLE

@Entity(tableName = BUDGET_TABLE)
data class Budget(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var healthLimit: Double,
    var foodLimit: Double,
    var transportLimit: Double,
    var entertainmentLimit: Double,
    var utilitiesLimit: Double,
    var otherLimit: Double
)
