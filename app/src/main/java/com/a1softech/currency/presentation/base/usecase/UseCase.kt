package com.a1softech.currency.presentation.base.usecase

import com.a1softech.currency.presentation.base.NetworkResult
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharedFlow
import retrofit2.Response

interface UseCase<T, Params> : CoroutineScope {

    fun getStateFlow(): SharedFlow<T>
    suspend fun execute(params: Params?)

}

