package com.a1softech.currency.data.apiservice

import com.a1softech.currency.data.dto.CurrencyListModelDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/latest")
    suspend fun convertCurrency(
        @Query("access_key") access_key: String
    ): CurrencyListModelDto

}