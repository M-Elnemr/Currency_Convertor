package com.a1softech.currency.presentation.ui.converter.viewmodel

import com.a1softech.core.domain.model.CurrencyListModel
import com.a1softech.core.domain.result.NetworkResult

sealed class ConverterState {
    data class OnCurrencyStateChanged(val response: NetworkResult<CurrencyListModel>) : ConverterState()
}
