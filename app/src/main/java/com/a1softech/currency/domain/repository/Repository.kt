package com.a1softech.currency.domain.repository

import com.a1softech.currency.data.dto.CurrencyListModelDto
import retrofit2.Response

interface Repository {
    suspend fun fetchCurrencyList(access_key: String): Response<CurrencyListModelDto>
}