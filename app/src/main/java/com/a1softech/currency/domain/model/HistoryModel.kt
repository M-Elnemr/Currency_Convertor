package com.a1softech.currency.domain.model

class HistoryModel(
    var currencyFrom: String = "",
    var currencyTo: String = "",
    var amount: String = "1",
    var convertedValue: String = "",
    var date: String,
    var timeInMillis: Long
)