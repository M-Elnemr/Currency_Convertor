package com.a1softech.currency.presentation.ui.converter.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.a1softech.currency.domain.model.CurrencyListModel
import com.a1softech.currency.domain.usecase.FetchCurrencyListUseCase
import com.a1softech.currency.presentation.base.NetworkResult
import com.a1softech.currency.presentation.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.launch
import javax.inject.Inject

// ViewModel with MVI Flavour

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val fetchCurrencyListUseCase: FetchCurrencyListUseCase
) : BaseViewModel<ConverterState>() {

    init {
        viewModelScope.launch {
            fetchCurrencyListUseCase.getStateFlow().buffer().collect { onCurrencyStateChanged(it) }
        }

    }

    private fun onCurrencyStateChanged(result: NetworkResult<CurrencyListModel>) =
        viewModelScope.launch {
            mediator.emit(ConverterState.OnCurrencyStateChanged(result))
        }


    fun fetchCurrencyList(access_key: String) = fetchCurrencyListUseCase.invoke(access_key)

}