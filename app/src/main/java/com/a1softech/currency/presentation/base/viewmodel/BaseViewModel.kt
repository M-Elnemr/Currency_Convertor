package com.a1softech.currency.presentation.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged

abstract class BaseViewModel<T> : ViewModel() {
    protected val mediator: MutableSharedFlow<T> = MutableSharedFlow(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    fun getStateFlow() = mediator

    init {
        mediator.distinctUntilChanged()
    }
}