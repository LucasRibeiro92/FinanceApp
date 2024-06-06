package com.example.financeapp.model.di

import com.example.financeapp.model.repository.BudgetRepository
import com.example.financeapp.model.repository.TransactionRepository
import com.example.financeapp.ui.viewmodel.BudgetViewModel
import com.example.financeapp.ui.viewmodel.TransactionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val budgetModule = module {

    // ViewModels
    viewModel { BudgetViewModel(get()) }
    viewModel { TransactionViewModel(get()) }

    // Repositories
    single { BudgetRepository(get()) }
    single { TransactionRepository(get()) }

    // Database and DAOs
    single { provideDatabase(get()) }
    single { provideBudgetDao(get()) }
    single { provideTransactionDao(get()) }

}