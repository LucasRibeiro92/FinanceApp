package com.example.financeapp.utils

sealed class GeneralError(message: String): Throwable(message) {
    class DatabaseError(message: String) : GeneralError(message)
    class UnknownError(message: String) : GeneralError(message)
}