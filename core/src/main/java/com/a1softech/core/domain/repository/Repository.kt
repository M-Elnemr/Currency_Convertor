package com.a1softech.core.domain.repository

import com.a1softech.core.data.database.history.HistoryEntity
import com.a1softech.core.data.dto.CurrencyListModelDto
import kotlinx.coroutines.flow.Flow


interface Repository {
    suspend fun fetchCurrencyList(access_key: String): CurrencyListModelDto
    suspend fun fetchCurrencyHistoryList(params: HashMap<String, Any>): Flow<List<HistoryEntity>>
    suspend fun insertCurrencyConvertRecord(historyEntity: HistoryEntity)
}