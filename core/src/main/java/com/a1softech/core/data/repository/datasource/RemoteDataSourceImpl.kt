package com.a1softech.core.data.repository.datasource

import com.a1softech.core.data.apiservice.ApiInterface
import com.a1softech.core.data.dto.CurrencyListModelDto
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiInterface) :
    RemoteDataSource {
    override suspend fun fetchCurrencyList(access_key: String): CurrencyListModelDto =
        apiInterface.convertCurrency(access_key)

}