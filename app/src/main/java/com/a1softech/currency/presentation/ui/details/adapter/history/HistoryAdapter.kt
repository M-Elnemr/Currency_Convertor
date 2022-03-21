package com.a1softech.currency.presentation.ui.details.adapter.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import com.a1softech.currency.databinding.RowDateSeparatorLayoutBinding
import com.a1softech.currency.databinding.RowHistoryLayoutBinding
import com.a1softech.currency.domain.model.HistoryModel
import com.a1softech.currency.presentation.base.adapter.BaseAdapter
import com.a1softech.currency.presentation.base.adapter.BaseViewHolder
import com.a1softech.currency.presentation.base.adapter.DiffCallBack

class HistoryAdapter: BaseAdapter<HistoryModel>() {

    private val mDiffer = AsyncListDiffer(this, DiffCallBack<HistoryModel>())

    private val LAYOUT_DATE_SEPARATOR = 0
    private val LAYOUT_HISTORY = 1

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

        return when(viewType){
            LAYOUT_DATE_SEPARATOR -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RowDateSeparatorLayoutBinding.inflate(inflater)

                DateSeparatorViewHolder(binding)
            }
            else -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RowHistoryLayoutBinding.inflate(inflater)

                HistoryViewHolder(binding)
            }

        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder<HistoryModel>, position: Int) {
        holder.bind(mDiffer.currentList[position])
    }

    override fun getItemCount(): Int = mDiffer.currentList.size

    override fun getItemViewType(position: Int): Int {
        return if (mDiffer.currentList[position].convertedValue == "") LAYOUT_DATE_SEPARATOR else LAYOUT_HISTORY
    }

}