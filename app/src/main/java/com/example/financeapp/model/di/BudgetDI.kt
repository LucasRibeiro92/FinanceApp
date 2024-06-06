package com.example.financeapp.model.di

import android.content.Context
import androidx.room.Room
import com.example.financeapp.model.data.local.BudgetDatabase
import com.example.financeapp.utils.Constants.BUDGET_DATABASE

fun provideDatabase(context: Context): BudgetDatabase =
    Room.databaseBuilder(context, BudgetDatabase::class.java, BUDGET_DATABASE)
        .fallbackToDestructiveMigration()
        .build()

fun provideBudgetDao(db: BudgetDatabase) = db.budgetDao()
fun provideTransactionDao(db: BudgetDatabase) = db.transactionDao()