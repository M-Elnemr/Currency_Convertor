package com.a1softech.currency.presentation.ui.details.viewmodel

import com.a1softech.currency.domain.model.HistoryModel
import com.a1softech.currency.presentation.base.DatabaseResult

sealed class DetailsState {
    data class OnHistoricalFetched(val response: DatabaseResult<List<HistoryModel>>) :
        DetailsState()
}
