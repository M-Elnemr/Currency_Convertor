package com.a1softech.currency.domain.model

import java.io.Serializable

class CurrencyPopularModel(
    val baseCurrency: String = "",
    val popularCurrencies: ArrayList<PopularCurrency> = arrayListOf()
) : Serializable

class PopularCurrency(
    val currency: String = "",
    val rate: Double = 0.0
) : Serializable