package com.a1softech.core.data.repository.datasource

import com.a1softech.core.data.database.history.HistoryEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertCurrencyConvertRecord(historyEntity: HistoryEntity)
    suspend fun fetchCurrencyHistoryList(params: HashMap<String, Any>): Flow<List<HistoryEntity>>

}