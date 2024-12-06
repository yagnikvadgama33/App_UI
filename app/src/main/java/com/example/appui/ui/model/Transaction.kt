package com.example.appui.ui.model

import com.TransactionType

data class Transaction(
    val name: String,
    val amount: Int,
    val date: String,
    val transactionType: TransactionType,
    val profilePic: Int?
)