package com.a1softech.currency.domain.usecase

import com.a1softech.currency.data.database.history.HistoryEntity
import com.a1softech.currency.presentation.base.usecase.BaseUseCase
import javax.inject.Inject

class SaveCurrencyRecordUseCase @Inject constructor() :
    BaseUseCase<Boolean, HistoryEntity>() {

    override suspend fun execute(params: HistoryEntity?) {
        params?.let { repo.insertCurrencyConvertRecord(it) }
    }
}