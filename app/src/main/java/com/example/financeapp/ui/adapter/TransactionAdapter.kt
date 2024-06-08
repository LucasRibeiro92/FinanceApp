package com.example.financeapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.financeapp.R
import com.example.financeapp.databinding.ItemTransactionBinding
import com.example.financeapp.model.data.local.entity.Transaction
import com.example.financeapp.ui.viewmodel.TransactionViewModel

class TransactionAdapter(
    private var transactions: List<Transaction>
) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.bind(transaction)
    }

    override fun getItemCount(): Int = transactions.size

    fun updateTransactions(newTransactions: List<Transaction>) {
        transactions = newTransactions
        notifyDataSetChanged()
    }

    inner class TransactionViewHolder(private val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(transaction: Transaction) {
            binding.tvTransactionCategory.text = transaction.category
            binding.tvTransactionDate.text = transaction.date
            binding.tvTransactionAmount.text = transaction.amount.toString()

            if (transaction.type == "Income") {
                binding.ivTransactionType.setImageResource(R.drawable.ic_income) // Replace with your income icon
                binding.tvTransactionAmount.setTextColor(itemView.context.getColor(R.color.mygreen)) // Replace with your income color
            } else {
                binding.ivTransactionType.setImageResource(R.drawable.ic_expense) // Replace with your expense icon
                binding.tvTransactionAmount.setTextColor(itemView.context.getColor(R.color.mybrown2 )) // Replace with your expense color
            }
        }
    }
}