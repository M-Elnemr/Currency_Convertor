package com.a1softech.currency.domain.usecase

import android.util.Log
import com.a1softech.currency.data.dto.CurrencyListModelDto
import com.a1softech.currency.domain.model.CurrencyListModel
import com.a1softech.currency.presentation.base.NetworkResult
import com.a1softech.currency.presentation.base.usecase.BaseUseCase
import retrofit2.Response
import javax.inject.Inject

class FetchCurrencyListUseCase:
    BaseUseCase<Response<CurrencyListModelDto>, NetworkResult<CurrencyListModel>, String>() {

    override suspend fun execute(params: String?) {
        stateFlow.emit(NetworkResult.Loading())
        try {

            stateFlow.emit(handleResult(repo.fetchCurrencyList(params ?: "")))

        } catch (e: Exception) {
            Log.d("TAG", "execute: ${e.message}")

            stateFlow.emit(NetworkResult.Error(e.message))
        }
    }


    override fun handleResult(response: Response<CurrencyListModelDto>): NetworkResult<CurrencyListModel> {
        return when {
            response.code() == 200 && response.isSuccessful && response.body() == null -> NetworkResult.Empty()

            response.code() == 200 && response.isSuccessful -> NetworkResult.Success(mapper.currencyMapper(response.body()!!))

            response.message().contains("timeout") -> NetworkResult.Error("TimeOut")

            else -> NetworkResult.Error(response.message())

        }
    }

}