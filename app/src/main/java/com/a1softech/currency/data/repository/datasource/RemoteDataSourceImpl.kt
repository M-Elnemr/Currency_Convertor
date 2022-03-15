package com.a1softech.currency.data.repository.datasource

import com.a1softech.currency.data.apiservice.ApiInterface
import com.a1softech.currency.data.dto.CurrencyListModelDto
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiInterface) :
    RemoteDataSource {
    override suspend fun fetchCurrencyList(access_key: String): Response<CurrencyListModelDto> = apiInterface.convertCurrency(access_key)

}