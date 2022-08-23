package com.a1softech.currency.presentation.ui.details.viewmodel

import androidx.lifecycle.viewModelScope
import com.a1softech.core.domain.model.HistoryModel
import com.a1softech.core.domain.usecase.FetchCurrencyHistoryUseCase
import com.a1softech.core.domain.result.DatabaseResult
import com.a1softech.currency.presentation.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.launch
import javax.inject.Inject

// ViewModel with MVI Flavour

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val fetchCurrencyHistoryUseCase: FetchCurrencyHistoryUseCase
) : BaseViewModel<DetailsState>() {

    init {
        viewModelScope.launch {
            fetchCurrencyHistoryUseCase.getStateFlow().buffer()
                .collect { onCurrencyStateChanged(it) }
        }
    }

    private fun onCurrencyStateChanged(result: DatabaseResult<List<HistoryModel>>) =
        viewModelScope.launch {
            mediator.emit(DetailsState.OnHistoricalFetched(result))
        }

    fun fetchCurrencyHistory(params: HashMap<String, Any>) =
        fetchCurrencyHistoryUseCase.invoke(params)

}