package com.a1softech.currency.presentation.util

import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.databinding.BindingAdapter
import org.jsoup.Jsoup

class MainBindingAdapter {
    companion object {
        @BindingAdapter("setNoneStringText")
        @JvmStatic
        fun setNoneStringText(textView: TextView, text: Any) {
            textView.text = text.toString()
        }

        @BindingAdapter("app:setItems")
        @JvmStatic
        fun AutoCompleteTextView.setItems(items: List<Any>?) {
            items?.let {
                val adapter =
                    ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, it)
                this.setAdapter(adapter)
            }
        }

        @BindingAdapter("app:setDefaultIndex")
        @JvmStatic
        fun AutoCompleteTextView.atIndex(index: Int) {
            adapter?.let {
                val itemAtPosition = it.getItem(index) as String
                this.setText(itemAtPosition, false)
            }
        }

        @BindingAdapter("app:visibleGone")
        @JvmStatic
        fun View.visibleGone(gone: Boolean) {
            isGone = gone
        }

        @BindingAdapter("app:disable")
        @JvmStatic
        fun View.disable(disable: Boolean) {
            isEnabled = !disable
        }

        @BindingAdapter("toggleVisibility")
        @JvmStatic
        fun toggleVisibility(view: View, isVisible: Boolean) {
            if (isVisible) {
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }
        }

        @BindingAdapter("parseHtml")
        @JvmStatic
        fun parseHtml(textView: TextView, text: String?) {
            text?.let {
                val txt = Jsoup.parse(it).text()
                textView.text = txt
            }

        }


    }

}