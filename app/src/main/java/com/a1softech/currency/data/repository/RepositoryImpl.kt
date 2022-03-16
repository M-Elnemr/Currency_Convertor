package com.a1softech.currency.data.repository

import com.a1softech.currency.data.dto.CurrencyListModelDto
import com.a1softech.currency.data.repository.datasource.LocalDataSource
import com.a1softech.currency.data.repository.datasource.RemoteDataSource
import com.a1softech.currency.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {
    override suspend fun fetchCurrencyList(access_key: String): Response<CurrencyListModelDto> =
        remoteDataSource.fetchCurrencyList(access_key)

}