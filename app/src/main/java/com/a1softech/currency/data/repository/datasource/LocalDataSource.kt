package com.a1softech.currency.data.repository.datasource

import com.a1softech.currency.data.database.history.HistoryEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertCurrencyConvertRecord(historyEntity: HistoryEntity)
    suspend fun fetchCurrencyHistoryList(params: HashMap<String, Any>): Flow<List<HistoryEntity>>

}