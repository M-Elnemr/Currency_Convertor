package com.a1softech.core.domain.usecase

import com.a1softech.core.data.database.history.HistoryEntity
import com.a1softech.core.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class SaveCurrencyRecordUseCase @Inject constructor() :
    BaseUseCase<Boolean, HistoryEntity>() {

    override suspend fun execute(params: HistoryEntity?) {
        params?.let { repo.insertCurrencyConvertRecord(it) }
    }
}