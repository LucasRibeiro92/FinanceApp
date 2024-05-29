package com.example.financeapp.model.di

import androidx.room.Room
import com.example.financeapp.model.data.local.BudgetDatabase
import com.example.financeapp.model.repository.BudgetCategoryRepository
import com.example.financeapp.model.repository.ExpenseRepository
import com.example.financeapp.model.repository.IncomeRepository
import com.example.financeapp.utils.Constants.BUDGET_DATABASE
import com.example.financeapp.viewmodel.BudgetCategoryViewModel
import com.example.financeapp.viewmodel.ExpenseViewModel
import com.example.financeapp.viewmodel.IncomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val budgetModule = module {
    // ViewModels
    viewModel { IncomeViewModel(get()) }
    viewModel { ExpenseViewModel(get()) }
    viewModel { BudgetCategoryViewModel(get()) }

    // Repositories
    single { IncomeRepository(get()) }
    single { ExpenseRepository(get()) }
    single { BudgetCategoryRepository(get()) }

    // Database and DAOs
    single { provideDatabase(get()) }
    single { provideIncomeDao(get()) }
    single { provideExpenseDao(get()) }
    single { provideBudgetCategoryDao(get()) }
}