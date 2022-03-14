package com.a1softech.currency.presentation.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.preventDoubleClick() {
    isClickable = false
    Handler(Looper.myLooper()!!).postDelayed({ isClickable = true }, 500L)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

