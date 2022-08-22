package com.a1softech.currency.presentation.ui.details.adapter.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import com.a1softech.currency.databinding.RowPopularLayoutBinding
import com.a1softech.core.domain.model.PopularCurrency
import com.a1softech.currency.presentation.base.adapter.BaseAdapter
import com.a1softech.currency.presentation.base.adapter.BaseViewHolder
import com.a1softech.currency.presentation.base.adapter.DiffCallBack

class PopularCurrencyAdapter: BaseAdapter<PopularCurrency>() {

    private val mDiffer = AsyncListDiffer(this, DiffCallBack<PopularCurrency>())

    override fun setDataList(dataList: List<PopularCurrency>) {
        mDiffer.submitList(dataList)
    }

    override fun addDataList(dataList: List<PopularCurrency>) {
        mDiffer.currentList.addAll(dataList)
    }

    override fun clearDataList() {
        mDiffer.currentList.clear()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<PopularCurrency> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowPopularLayoutBinding.inflate(inflater)

        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<PopularCurrency>, position: Int) {
        holder.bind(mDiffer.currentList[position])
    }

    override fun getItemCount(): Int = mDiffer.currentList.size

}