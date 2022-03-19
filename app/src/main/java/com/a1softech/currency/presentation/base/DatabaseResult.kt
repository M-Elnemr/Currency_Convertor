package com.a1softech.currency.presentation.base

sealed class DatabaseResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(response: T) : DatabaseResult<T>(response)
    class Loading<T> : DatabaseResult<T>()
    class Error<T>(message: String?, response: T? = null): DatabaseResult<T>(response, message)

}