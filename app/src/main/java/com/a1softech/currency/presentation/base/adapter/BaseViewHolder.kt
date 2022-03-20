package com.a1softech.currency.presentation.base.adapter

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.github.florent37.expansionpanel.ExpansionLayout
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<in T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root), LayoutContainer {
    protected val context = binding.root.context
    protected val resources = binding.root.resources
    override val containerView: View = binding.root

    abstract fun bind(result: T)
}