package com.a1softech.currency.data.repository.datasource

import com.a1softech.currency.data.database.history.HistoryEntity

interface LocalDataSource {
    suspend fun insertCurrencyConvertRecord(historyEntity: HistoryEntity)
}