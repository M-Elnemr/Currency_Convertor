package com.a1softech.currency.presentation.ui.details.adapter.history

import com.a1softech.currency.databinding.RowHistoryLayoutBinding
import com.a1softech.currency.databinding.RowPopularLayoutBinding
import com.a1softech.currency.domain.model.HistoryModel
import com.a1softech.currency.domain.model.PopularCurrency
import com.a1softech.currency.presentation.base.adapter.BaseViewHolder

class HistoryViewHolder(private val binding: RowHistoryLayoutBinding) :
    BaseViewHolder<HistoryModel>(binding) {
    override fun bind(result: HistoryModel) {
        binding.history = result
    }
}