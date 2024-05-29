package com.example.financeapp.model.di

import androidx.room.Room
import com.example.financeapp.model.data.local.BudgetDatabase
import com.example.financeapp.utils.Constants.BUDGET_DATABASE
import org.koin.dsl.module

val budgetModule = module {
    /*
    // ViewModels
    viewModel { IncomeViewModel(get()) }
    viewModel { ExpenseViewModel(get()) }
    viewModel { BudgetCategoryViewModel(get()) }

    // Repositories
    single { IncomeRepository(get()) }
    single { ExpenseRepository(get()) }
    single { BudgetCategoryRepository(get()) }

     */

    // DAOs
    single { get<BudgetDatabase>().incomeDao() }
    single { get<BudgetDatabase>().expenseDao() }
    single { get<BudgetDatabase>().budgetCategoryDao() }

    // Database
    single {
        Room.databaseBuilder(get(), BudgetDatabase::class.java, BUDGET_DATABASE).build()
    }
}