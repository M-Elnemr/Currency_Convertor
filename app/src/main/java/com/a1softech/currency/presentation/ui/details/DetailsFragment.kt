package com.a1softech.currency.presentation.ui.details

import com.a1softech.currency.R
import com.a1softech.currency.databinding.FragmentDetailsBinding
import com.a1softech.currency.domain.model.CurrencyPopularModel
import com.a1softech.currency.presentation.base.view.BaseFragment

class DetailsFragment(override val layoutResourceLayout: Int = R.layout.fragment_details) :
    BaseFragment<FragmentDetailsBinding>() {

    lateinit var currencyPopularModel: CurrencyPopularModel

    override fun onFragmentCreated(dataBinder: FragmentDetailsBinding) {
        val args = DetailsFragmentArgs.fromBundle(requireArguments())
        currencyPopularModel = args.currencyPopularModel
    }

    override fun setUpViewModelStateObservers() {
    }

}