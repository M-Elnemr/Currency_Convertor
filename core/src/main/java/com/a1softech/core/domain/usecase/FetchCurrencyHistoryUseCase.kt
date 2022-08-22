package com.a1softech.core.domain.usecase

import com.a1softech.core.domain.model.HistoryModel
import com.a1softech.core.domain.result.DatabaseResult
import com.a1softech.core.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class FetchCurrencyHistoryUseCase @Inject constructor() :
    BaseUseCase<DatabaseResult<List<HistoryModel>>, HashMap<String, Any>>() {

    override suspend fun execute(params: HashMap<String, Any>?) {
        stateFlow.emit(DatabaseResult.Loading())

        try {
            repo.fetchCurrencyHistoryList(params!!).collect {
                stateFlow.emit(
                    DatabaseResult.Success(
                        mapper.historyMapper(it)
                    )
                )
            }
        }catch (e: Exception){
            stateFlow.emit(DatabaseResult.Error(e.toString()))
        }
    }
}