package com.a1softech.currency.data.repository.datasource

import com.a1softech.currency.data.dto.CurrencyListModelDto
import retrofit2.Response

interface RemoteDataSource {
    suspend fun fetchCurrencyList(access_key: String): Response<CurrencyListModelDto>
}