package com.a1softech.currency.data.repository.datasource

import com.a1softech.currency.data.database.history.HistoryDao
import com.a1softech.currency.data.database.history.HistoryEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val historyDao: HistoryDao) :
    LocalDataSource {
    override suspend fun insertCurrencyConvertRecord(historyEntity: HistoryEntity) =
        historyDao.insertCurrencyConvertRecord(historyEntity)

}