package com.a1softech.currency.presentation.ui.details

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.a1softech.currency.R
import com.a1softech.currency.databinding.FragmentDetailsBinding
import com.a1softech.currency.domain.model.CurrencyPopularModel
import com.a1softech.currency.domain.model.HistoryModel
import com.a1softech.currency.presentation.base.DatabaseResult
import com.a1softech.currency.presentation.base.view.BaseFragment
import com.a1softech.currency.presentation.ui.details.viewmodel.DetailsState
import com.a1softech.currency.presentation.ui.details.viewmodel.DetailsViewModel
import com.a1softech.currency.presentation.util.Constants
import kotlinx.coroutines.launch

class DetailsFragment(override val layoutResourceLayout: Int = R.layout.fragment_details) :
    BaseFragment<FragmentDetailsBinding>() {

    val viewModel by viewModels<DetailsViewModel>()

    lateinit var currencyPopularModel: CurrencyPopularModel

    override fun onFragmentCreated(dataBinder: FragmentDetailsBinding) {
        val args = DetailsFragmentArgs.fromBundle(requireArguments())
        currencyPopularModel = args.currencyPopularModel

        fetchCurrencyHistory(currencyPopularModel.baseCurrency)
    }

    private fun fetchCurrencyHistory(baseCurrency: String) {
        val params: HashMap<String, Any> = hashMapOf()
        params[Constants.CURRENCY_CODE] = baseCurrency
        params[Constants.DATE_LIST] = prepareDateList()
        viewModel.fetchCurrencyHistory(params)
    }

    private fun prepareDateList(): List<String> {
        //TODO
        return listOf()
    }

    override fun setUpViewModelStateObservers() {
        lifecycleScope.launch {
            viewModel.getStateFlow().collect {
                onStateChanged(it)
            }
        }
    }

    private fun onStateChanged(state: DetailsState) {
        when (state) {
            is DetailsState.OnHistoricalFetched -> {
                onCurrencyHistoryFetcher(state.response)
            }
        }
    }

    private fun onCurrencyHistoryFetcher(response: DatabaseResult<List<HistoryModel>>) {
        when (response) {
            is DatabaseResult.Loading -> {}
            is DatabaseResult.Error -> {}
            is DatabaseResult.Success -> {}
        }
    }

}