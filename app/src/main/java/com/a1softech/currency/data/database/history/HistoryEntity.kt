package com.a1softech.currency.data.database.history

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.a1softech.currency.presentation.util.Constants.HISTORY_TABLE
import java.time.LocalDate
import java.util.*

@Entity(tableName = HISTORY_TABLE)
class HistoryEntity(
    var currencyFrom: String = "",
    var currencyTo: String = "",
    var amount: String = "1",
    var convertedValue: String = "",
    var date: String,
    var timeInMillis: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}