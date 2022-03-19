package com.a1softech.currency.data.repository

import com.a1softech.currency.data.database.history.HistoryEntity
import com.a1softech.currency.data.dto.CurrencyListModelDto
import com.a1softech.currency.data.repository.datasource.LocalDataSource
import com.a1softech.currency.data.repository.datasource.RemoteDataSource
import com.a1softech.currency.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {
    override suspend fun fetchCurrencyList(access_key: String): CurrencyListModelDto =
        remoteDataSource.fetchCurrencyList(access_key)

    override suspend fun fetchCurrencyHistoryList(params: HashMap<String, Any>): Flow<List<HistoryEntity>> =
        localDataSource.fetchCurrencyHistoryList(params)

    override suspend fun insertCurrencyConvertRecord(historyEntity: HistoryEntity) =
        localDataSource.insertCurrencyConvertRecord(historyEntity)

}