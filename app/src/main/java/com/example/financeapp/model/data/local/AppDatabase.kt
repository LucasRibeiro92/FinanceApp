package com.example.financeapp.model.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.financeapp.model.data.local.dao.BudgetCategoryDao
import com.example.financeapp.model.data.local.dao.ExpenseDao
import com.example.financeapp.model.data.local.dao.IncomeDao
import com.example.financeapp.model.data.local.entity.BudgetCategory
import com.example.financeapp.model.data.local.entity.Expense
import com.example.financeapp.model.data.local.entity.Income

@Database(entities = [Income::class, Expense::class, BudgetCategory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun incomeDao(): IncomeDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun budgetCategoryDao(): BudgetCategoryDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "app_database.db"
        ).build()
    }
}
