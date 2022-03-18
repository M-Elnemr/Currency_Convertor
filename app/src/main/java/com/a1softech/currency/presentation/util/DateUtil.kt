package com.a1softech.currency.presentation.util

import java.text.SimpleDateFormat
import java.util.*

fun getTodayDate(): String {
    val today = Calendar.getInstance()
    today.add(Calendar.DATE, 1)

    val todayDate: Date = today.time
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    return dateFormat.format(todayDate)
}

fun getTimeInMills(): Long =
    Calendar.getInstance().timeInMillis