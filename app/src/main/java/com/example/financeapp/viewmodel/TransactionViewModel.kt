package com.example.financeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financeapp.model.data.local.entity.Transaction
import com.example.financeapp.model.repository.TransactionRepository
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: TransactionRepository) : ViewModel()  {

    private val _transaction = MutableLiveData<List<Transaction>>()
    val transaction: LiveData<List<Transaction>> get() = _transaction

    fun insertExpense(transaction: Transaction) = viewModelScope.launch {
        repository.insertTransaction(transaction)
    }
}