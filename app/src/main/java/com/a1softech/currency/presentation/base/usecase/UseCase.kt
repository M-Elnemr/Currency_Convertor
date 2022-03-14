package com.a1softech.currency.presentation.base.usecase

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharedFlow

interface UseCase<T, Params> : CoroutineScope {

    fun getStateFlow(): SharedFlow<T>
    suspend fun execute(params: Params?)

}

