package com.a1softech.currency.presentation.ui.details.adapter.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import com.a1softech.currency.databinding.RowDateSpitterLayoutBinding
import com.a1softech.currency.databinding.RowHistoryLayoutBinding
import com.a1softech.currency.databinding.RowPopularLayoutBinding
import com.a1softech.currency.domain.model.HistoryModel
import com.a1softech.currency.presentation.base.adapter.BaseAdapter
import com.a1softech.currency.presentation.base.adapter.BaseViewHolder
import com.a1softech.currency.presentation.base.adapter.DiffCallBack
import com.a1softech.currency.presentation.ui.details.adapter.popular.PopularViewHolder

class HistoryAdapter: BaseAdapter<HistoryModel>() {

    private val mDiffer = AsyncListDiffer(this, DiffCallBack<HistoryModel>())

    var isNewDate : Boolean = true
    var tempDate: String = ""

    override fun setDataList(dataList: List<HistoryModel>) {
        mDiffer.submitList(dataList)
    }

    override fun addDataList(dataList: List<HistoryModel>) {
        mDiffer.currentList.addAll(dataList)
    }

    override fun clearDataList() {
        mDiffer.currentList.clear()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<HistoryModel> {

        val inflater = LayoutInflater.from(parent.context)
        val binding = RowHistoryLayoutBinding.inflate(inflater)

        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<HistoryModel>, position: Int) {
        holder.bind(mDiffer.currentList[position])
    }

    override fun getItemCount(): Int = mDiffer.currentList.size

}