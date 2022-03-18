package com.a1softech.currency.data.repository.datasource

import com.a1softech.currency.data.dto.CurrencyListModelDto

interface RemoteDataSource {
    suspend fun fetchCurrencyList(access_key: String): CurrencyListModelDto
}