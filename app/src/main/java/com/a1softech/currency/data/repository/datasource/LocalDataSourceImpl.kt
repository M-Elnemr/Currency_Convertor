package com.a1softech.currency.data.repository.datasource

import com.a1softech.currency.data.database.history.HistoryDao
import com.a1softech.currency.data.database.history.HistoryEntity
import com.a1softech.currency.presentation.util.Constants
import com.a1softech.currency.presentation.util.Constants.DATE_LIST
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val historyDao: HistoryDao) :
    LocalDataSource {
    override suspend fun insertCurrencyConvertRecord(historyEntity: HistoryEntity) =
        historyDao.insertCurrencyConvertRecord(historyEntity)

    override suspend fun fetchCurrencyHistoryList(params: HashMap<String, Any>): Flow<List<HistoryEntity>> {
        historyDao.deleteOldHistoricalRecords(params[DATE_LIST]!! as List<String>)

        return  historyDao.fetchHistoricalRecordsByCurrencyCodeAndDateList(
            params[Constants.CURRENCY_CODE]!! as String, params[DATE_LIST]!! as List<String>
        )
    }
}