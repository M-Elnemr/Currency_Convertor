package com.a1softech.core.data.repository.datasource

import com.a1softech.core.data.database.history.HistoryDao
import com.a1softech.core.data.database.history.HistoryEntity
import com.a1softech.core.data.util.Constants
import com.a1softech.core.data.util.Constants.DATE_LIST
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val historyDao: HistoryDao) :
    LocalDataSource {
    override suspend fun insertCurrencyConvertRecord(historyEntity: HistoryEntity) =
        historyDao.insertCurrencyConvertRecord(historyEntity)

    override suspend fun fetchCurrencyHistoryList(params: HashMap<String, Any>): Flow<List<HistoryEntity>> {
        historyDao.deleteOldHistoricalRecords(params[DATE_LIST]!! as List<String>)

        return historyDao.fetchHistoricalRecordsByCurrencyCodeAndDateList(
            params[Constants.BASE_CURRENCY_CODE]!! as String,
            params[Constants.OTHER_CURRENCY_CODE]!! as String,
            params[DATE_LIST]!! as List<String>
        )
    }
}