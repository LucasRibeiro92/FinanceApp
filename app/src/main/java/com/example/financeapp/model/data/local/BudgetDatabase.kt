package com.example.financeapp.model.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.financeapp.model.data.local.dao.BudgetDao
import com.example.financeapp.model.data.local.dao.ExpenseDao
import com.example.financeapp.model.data.local.dao.IncomeDao
import com.example.financeapp.model.data.local.entity.Budget
import com.example.financeapp.model.data.local.entity.Expense
import com.example.financeapp.model.data.local.entity.Income
import com.example.financeapp.utils.Constants.BUDGET_DATABASE

@Database(entities = [Budget::class, Income::class, Expense::class], version = 5)
abstract class BudgetDatabase : RoomDatabase() {

    abstract fun budgetDao(): BudgetDao
    abstract fun incomeDao(): IncomeDao
    abstract fun expenseDao(): ExpenseDao

    companion object {
        @Volatile private var instance: BudgetDatabase? = null

        fun getInstance(context: Context): BudgetDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                BudgetDatabase::class.java, BUDGET_DATABASE)
                .fallbackToDestructiveMigration()
                .build()
    }
}