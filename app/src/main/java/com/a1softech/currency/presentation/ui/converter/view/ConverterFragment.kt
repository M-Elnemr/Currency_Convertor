package com.a1softech.currency.presentation.ui.converter.view

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.a1softech.currency.R
import com.a1softech.currency.databinding.FragmentConverterBinding
import com.a1softech.currency.domain.model.CurrencyListModel
import com.a1softech.currency.presentation.base.NetworkResult
import com.a1softech.currency.presentation.base.view.BaseFragment
import com.a1softech.currency.presentation.ui.converter.viewmodel.ConverterState
import com.a1softech.currency.presentation.ui.converter.viewmodel.ConverterViewModel
import com.a1softech.currency.presentation.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_converter.view.*
import kotlinx.coroutines.flow.buffer


@AndroidEntryPoint
class ConverterFragment(override val layoutResourceLayout: Int = R.layout.fragment_converter) :
    BaseFragment<FragmentConverterBinding>() {

    private val viewModel by viewModels<ConverterViewModel>()

    override fun onFragmentCreated(dataBinder: FragmentConverterBinding) {
        viewModel.fetchCurrencyList(Constants.access_key)
    }

    override fun setUpViewModelStateObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.getStateFlow().buffer().collect {
                onStateChanged(it)
            }
        }
    }

    private fun onStateChanged(state: ConverterState) {
        when (state) {
            is ConverterState.OnCurrencyStateChanged -> {
                onCurrencyFetched(state.response)
            }
        }
    }

    private fun onCurrencyFetched(result: NetworkResult<CurrencyListModel>) {
        when (result) {
            is NetworkResult.Empty -> rootView.status.text = "Empty"
            is NetworkResult.Error -> rootView.status.text = result.message
            is NetworkResult.Loading -> rootView.status.text = "Loading"
            is NetworkResult.NoInternet -> rootView.status.text = "No Internet"
            is NetworkResult.Success -> rootView.status.text = result.data.toString()
        }
    }

}