package com.a1softech.currency.domain.usecase

import android.util.Log
import androidx.compose.ui.text.toLowerCase
import com.a1softech.currency.data.dto.CurrencyListModelDto
import com.a1softech.currency.data.mapper.Mapper
import com.a1softech.currency.domain.model.CurrencyListModel
import com.a1softech.currency.domain.repository.Repository
import com.a1softech.currency.presentation.base.NetworkResult
import com.a1softech.currency.presentation.base.usecase.BaseUseCase
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.util.*
import javax.inject.Inject

class FetchCurrencyListUseCase @Inject constructor() :
    BaseUseCase<Response<CurrencyListModelDto>, NetworkResult<CurrencyListModel>, String>() {

    override suspend fun execute(params: String?) {
        stateFlow.emit(NetworkResult.Loading())
        try {

            stateFlow.emit(handleResult(repo.fetchCurrencyList(params ?: "")))

        } catch (e: HttpException) {
            Log.d("TAG", "execute: ${e.message}")

            stateFlow.emit(NetworkResult.ServerError(e.message))
        }catch (e: IOException){

            stateFlow.emit(NetworkResult.NetworkError(e.message))
        }
    }

    override fun handleResult(response: Response<CurrencyListModelDto>): NetworkResult<CurrencyListModel> {
        return when {
            response.code() == 200 && response.isSuccessful && response.body() == null -> NetworkResult.Empty()
            response.code() == 200 && response.isSuccessful -> NetworkResult.Success(
                mapper.currencyMapper(
                    response.body()!!
                )
            )
            else -> NetworkResult.ServerError(response.message())
        }
    }

}