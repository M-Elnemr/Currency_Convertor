package com.a1softech.currency.presentation.ui.details.view

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.a1softech.currency.R
import com.a1softech.currency.databinding.FragmentDetailsBinding
import com.a1softech.currency.domain.model.CurrencyPopularModel
import com.a1softech.currency.domain.model.HistoryModel
import com.a1softech.currency.domain.model.PopularCurrency
import com.a1softech.currency.presentation.base.DatabaseResult
import com.a1softech.currency.presentation.base.adapter.BaseAdapter
import com.a1softech.currency.presentation.base.view.BaseFragment
import com.a1softech.currency.presentation.ui.details.adapter.history.HistoryAdapter
import com.a1softech.currency.presentation.ui.details.adapter.popular.PopularCurrencyAdapter
import com.a1softech.currency.presentation.ui.details.viewmodel.DetailsState
import com.a1softech.currency.presentation.ui.details.viewmodel.DetailsViewModel
import com.a1softech.currency.presentation.util.Constants
import com.a1softech.currency.presentation.util.getDate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment(override val layoutResourceLayout: Int = R.layout.fragment_details) :
    BaseFragment<FragmentDetailsBinding>() {

    val viewModel by viewModels<DetailsViewModel>()

    lateinit var currencyPopularModel: CurrencyPopularModel

    private val historyAdapter: BaseAdapter<HistoryModel> by lazy { HistoryAdapter() }
    private val popularAdapter: BaseAdapter<PopularCurrency> by lazy { PopularCurrencyAdapter() }

    override fun onFragmentCreated(dataBinder: FragmentDetailsBinding) {
        val args = DetailsFragmentArgs.fromBundle(requireArguments())
        currencyPopularModel = args.currencyPopularModel

        bindData(currencyPopularModel)
        setUpPopularAdapter(currencyPopularModel)

        fetchCurrencyHistory(currencyPopularModel)
        prepareRecyclerView()
    }

    private fun bindData(currencyPopularModel: CurrencyPopularModel) {
        dataBinder.fromCurrency = currencyPopularModel.baseCurrency
        dataBinder.toCurrency = currencyPopularModel.otherCurrency
    }

    private fun setUpPopularAdapter(currencyPopularModel: CurrencyPopularModel) {
        popularAdapter.setDataList(currencyPopularModel.popularCurrencies)
    }

    private fun prepareRecyclerView() {
        initRecyclerView(rootView.rv_historical, historyAdapter)
        initRecyclerView(rootView.rv_popular, popularAdapter)
    }


    private fun fetchCurrencyHistory(currencyPopularModel: CurrencyPopularModel) {
        val params: HashMap<String, Any> = hashMapOf()
        params[Constants.BASE_CURRENCY_CODE] = currencyPopularModel.baseCurrency
        params[Constants.OTHER_CURRENCY_CODE] = currencyPopularModel.otherCurrency
        params[Constants.DATE_LIST] = prepareDateList()
        viewModel.fetchCurrencyHistory(params)
    }

    private fun prepareDateList(): List<String> {
        val dateList: ArrayList<String> = arrayListOf()
        dateList.add(getDate(0))
        dateList.add(getDate(-1))
        dateList.add(getDate(-2))

        Log.d("TAG", "prepareDateList:${dateList} ")

        return dateList
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
            is DatabaseResult.Success -> {
                setUpHistoryAdapter(response.data)
            }
        }
    }

    private fun setUpHistoryAdapter(data: List<HistoryModel>?) {
        data?.let {

            historyAdapter.setDataList(handleHistoricalList(data))
        }
    }

    private fun handleHistoricalList(data: List<HistoryModel>): ArrayList<HistoryModel> {
        val organizedHistoricalList: ArrayList<HistoryModel> = arrayListOf()
        var tempDate = ""

        data.forEach {
            if (it.date != tempDate) {
                organizedHistoricalList.add(HistoryModel(date = it.date))
                tempDate = it.date
            }

            organizedHistoricalList.add(it)

        }

        return organizedHistoricalList
    }

}