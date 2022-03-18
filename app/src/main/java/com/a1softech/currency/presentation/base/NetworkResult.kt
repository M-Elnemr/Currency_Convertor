package com.a1softech.currency.presentation.base

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(response: T) : NetworkResult<T>(response)
    class ServerError<T>(message: String?, response: T? = null): NetworkResult<T>(response, message)
    class NetworkError<T>(message: String?, response: T? = null): NetworkResult<T>(response, message)
    class Loading<T>: NetworkResult<T>()
}