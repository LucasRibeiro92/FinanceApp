package com.example.financeapp.model.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.financeapp.model.data.local.entity.Transaction
import com.example.financeapp.utils.Constants.TRANSACTION_TABLE

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM $TRANSACTION_TABLE")
    fun getAllTransactions(): LiveData<List<Transaction>>

}