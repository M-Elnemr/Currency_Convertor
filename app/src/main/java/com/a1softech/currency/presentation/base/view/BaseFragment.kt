package com.a1softech.currency.presentation.base.view

import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.a1softech.currency.R

abstract class BaseFragment<T> : Fragment() where T : ViewDataBinding {
    @get:LayoutRes
    protected abstract val layoutResourceLayout: Int

    lateinit var rootView: View
    lateinit var dataBinder: T

    val params: HashMap<String, String> = hashMapOf()

    abstract fun onFragmentCreated(dataBinder: T)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModelStateObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this@BaseFragment.layoutResourceLayout.let {
            dataBinder = DataBindingUtil.inflate(inflater, it, container, false)

            rootView = dataBinder.root
            this@BaseFragment.onFragmentCreated(dataBinder)
        }

        return rootView
    }

    abstract fun setUpViewModelStateObservers()

    protected fun initRecyclerView(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        adapter.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

        recyclerView.let {
            it.adapter = adapter
            it.addItemDecoration(provideItemDecorator())
        }
    }

    private fun provideItemDecorator(): DividerItemDecoration {
        val itemDecorator =
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.devider
            )!!
        )

        return itemDecorator
    }


}