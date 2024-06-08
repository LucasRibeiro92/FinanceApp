package com.example.financeapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.model.data.local.entity.Transaction
import com.example.financeapp.model.repository.TransactionRepository
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: TransactionRepository) : ViewModel()  {

    val allTransactions: LiveData<List<Transaction>> = repository.allTransactions
    val totalIncome: LiveData<Double> = repository.getTotalIncome()
    val totalExpenses: LiveData<Double> = repository.getTotalExpenses()

    fun insertTransaction(transaction: Transaction) = viewModelScope.launch {
        repository.insertTransaction(transaction)
    }
}