package com.a1softech.currency.presentation.base.usecase

import com.a1softech.currency.data.mapper.Mapper
import com.a1softech.currency.domain.repository.Repository
import com.a1softech.currency.presentation.base.NetworkResult
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<D, T, Params>(
    // config the sharedflow to works the same as the stateflow - so we can use it without init value
    protected val stateFlow: MutableSharedFlow<T> = MutableSharedFlow(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
) : UseCase<D, T, Params> {

    @Inject
    lateinit var repo: Repository

    @Inject
    lateinit var mapper: Mapper

    init {
        // config the sharedflow to works the same as the stateflow - so we can use it without init value
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

    protected fun <A> startAsync(block: suspend () -> A): Deferred<A> =
        coroutineIOScope.async { block() }

    fun clear() {
        parentJob.cancel()
    }

    override fun getStateFlow(): SharedFlow<T> = stateFlow

    //for network response (with coroutines) NOT local response
    fun <K> handleResponse(response: Response<K>): NetworkResult<K> {
        return when {
            response.code() == 200 && response.isSuccessful && response.body() == null -> NetworkResult.Empty()

            response.code() == 200 && response.isSuccessful -> NetworkResult.Success(response.body()!!)

            response.message().contains("timeout") -> NetworkResult.Error("TimeOut")

            else -> NetworkResult.Error(response.message())

        }
    }

}
