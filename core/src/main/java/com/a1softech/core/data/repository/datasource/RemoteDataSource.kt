package com.a1softech.core.data.repository.datasource

import com.a1softech.core.data.dto.CurrencyListModelDto

interface RemoteDataSource {
    suspend fun fetchCurrencyList(access_key: String): CurrencyListModelDto
}