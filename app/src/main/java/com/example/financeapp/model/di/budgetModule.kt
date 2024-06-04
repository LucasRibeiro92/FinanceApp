package com.example.financeapp.model.di

import com.example.financeapp.model.repository.BudgetRepository
import com.example.financeapp.model.repository.ExpenseRepository
import com.example.financeapp.model.repository.IncomeRepository
import com.example.financeapp.viewmodel.BudgetViewModel
import com.example.financeapp.viewmodel.ExpenseViewModel
import com.example.financeapp.viewmodel.IncomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val budgetModule = module {

    // ViewModels
    viewModel { IncomeViewModel(get()) }
    viewModel { ExpenseViewModel(get()) }
    viewModel { BudgetViewModel(get()) }

    // Repositories
    single { IncomeRepository(get()) }
    single { ExpenseRepository(get()) }
    single { BudgetRepository(get()) }

    // Database and DAOs
    single { provideDatabase(get()) }
    single { provideIncomeDao(get()) }
    single { provideExpenseDao(get()) }
    single { provideBudgetDao(get()) }

}