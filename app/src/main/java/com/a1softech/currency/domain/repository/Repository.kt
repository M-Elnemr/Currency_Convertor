package com.a1softech.currency.domain.repository

import com.a1softech.currency.data.database.history.HistoryEntity
import com.a1softech.currency.data.dto.CurrencyListModelDto

interface Repository {
    suspend fun fetchCurrencyList(access_key: String): CurrencyListModelDto
    suspend fun insertCurrencyConvertRecord(historyEntity: HistoryEntity)
}