package com.a1softech.currency.presentation.ui.details.adapter.popular

import com.a1softech.currency.databinding.RowPopularLayoutBinding
import com.a1softech.core.domain.model.PopularCurrency
import com.a1softech.currency.presentation.base.adapter.BaseViewHolder

class PopularViewHolder(private val binding: RowPopularLayoutBinding) :
    BaseViewHolder<PopularCurrency>(binding) {
    override fun bind(result: PopularCurrency) {
        binding.popularCurrency = result
    }
}