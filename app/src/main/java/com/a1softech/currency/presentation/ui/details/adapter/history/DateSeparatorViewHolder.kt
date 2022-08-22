package com.a1softech.currency.presentation.ui.details.adapter.history

import com.a1softech.currency.databinding.RowDateSeparatorLayoutBinding
import com.a1softech.core.domain.model.HistoryModel
import com.a1softech.currency.presentation.base.adapter.BaseViewHolder

class DateSeparatorViewHolder(private val binding: RowDateSeparatorLayoutBinding) :
    BaseViewHolder<HistoryModel>(binding) {
    override fun bind(result: HistoryModel) {
        binding.date = result.date
    }
}