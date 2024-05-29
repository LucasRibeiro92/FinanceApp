package com.example.financeapp

import android.app.Application
import com.example.financeapp.model.di.budgetModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BudgetApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BudgetApp)
            modules(budgetModule)
        }
    }
}