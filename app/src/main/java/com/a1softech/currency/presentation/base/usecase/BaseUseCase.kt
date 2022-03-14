package com.a1softech.currency.presentation.base.usecase

import com.a1softech.currency.presentation.base.NetworkResult
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<T, Params>(
    // config the sharedflow to works the same as the stateflow - so we can use it without init value
    protected val stateFlow: MutableSharedFlow<T> = MutableSharedFlow(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
) : UseCase<T, Params> {

    init {
        stateFlow.distinctUntilChanged()
    }

    private val parentJob = SupervisorJob()
    private val mainDispatcher = Dispatchers.Main
    private val backgroundDispatcher = Dispatchers.Default
    private val backgroundIODispatcher = Dispatchers.IO
    private val coroutineIOScope: CoroutineScope =
        CoroutineScope(backgroundIODispatcher + parentJob)

    override val coroutineContext: CoroutineContext
        get() = parentJob + mainDispatcher

    operator fun invoke(
        params: Params?
    ) {
        launch(backgroundIODispatcher) {
            execute(params)
        }
    }

    protected fun <T> startAsync(block: suspend () -> T): Deferred<T> =
        coroutineIOScope.async { block() }

    fun clear() {
        parentJob.cancel()
    }

    override fun getStateFlow(): SharedFlow<T> = stateFlow

    //for network response (with corotinese) NOT local response
    fun <T> handleResponse(response: Response<T>): NetworkResult<T> {
        return when {
            response.code() == 200 && response.isSuccessful && response.body() == null -> {
                NetworkResult.Empty()
            }
            response.code() == 200 && response.isSuccessful -> {
                NetworkResult.Success(response.body()!!)
            }
            response.message().toString().contains("timeout") -> {
                NetworkResult.Error("TimeOut")
            }
            else -> {
                NetworkResult.Error(response.message())
            }
        }
    }

}
