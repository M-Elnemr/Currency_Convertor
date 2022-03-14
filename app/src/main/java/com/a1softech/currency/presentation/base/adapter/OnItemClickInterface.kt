package com.a1softech.currency.presentation.base.adapter

import android.view.View

interface OnItemClickInterface {
    fun onDetailsClicked(data: Any, view: View? = null)
    fun onMoreClicked(view: View, data: Any, position: Int){}
}