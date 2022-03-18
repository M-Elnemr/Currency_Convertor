package com.a1softech.currency.presentation.base

sealed class DataBaseResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(response: T) : DataBaseResult<T>(response)
    class Error<T>(message: String?, response: T? = null): DataBaseResult<T>(response, message)

}