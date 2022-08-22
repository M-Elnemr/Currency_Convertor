package com.a1softech.core.domain.usecase.base

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharedFlow

interface UseCase<T, Params> : CoroutineScope {

    fun getStateFlow(): SharedFlow<T>
    suspend fun execute(params: Params?)

}

