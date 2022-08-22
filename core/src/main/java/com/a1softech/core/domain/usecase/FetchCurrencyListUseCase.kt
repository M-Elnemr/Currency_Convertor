package com.a1softech.core.domain.usecase

import com.a1softech.core.domain.model.CurrencyListModel
import com.a1softech.core.domain.result.NetworkResult
import com.a1softech.core.domain.usecase.base.BaseUseCase
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FetchCurrencyListUseCase @Inject constructor() :
    BaseUseCase<NetworkResult<CurrencyListModel>, String>() {

    override suspend fun execute(params: String?) {
        stateFlow.emit(NetworkResult.Loading())
        try {
            stateFlow.emit(
                NetworkResult.Success(
                    mapper.currencyMapper(
                        repo.fetchCurrencyList(params ?: "")
                    )
                )
            )

        } catch (e: HttpException) {
            stateFlow.emit(NetworkResult.ServerError(e.message))
        } catch (e: IOException) {
            stateFlow.emit(NetworkResult.NetworkError(e.message))
        }
    }
}