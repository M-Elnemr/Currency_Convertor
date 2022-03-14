package com.a1softech.currency.presentation.base.bindingadapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.jsoup.Jsoup

class MainBindingAdapter {
    companion object {
        @BindingAdapter("setNoneStringText")
        @JvmStatic
        fun setNoneStringText(textView: TextView, text: Any) {
            textView.text = text.toString()
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