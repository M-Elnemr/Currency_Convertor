package com.a1softech.currency.data.apiservice

import com.a1softech.currency.data.dto.CurrencyListModelDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiInterface {

    @GET("latest")
    suspend fun convertCurrency(
        @QueryMap params: Map<String, String>
    ): Response<CurrencyListModelDto>

}