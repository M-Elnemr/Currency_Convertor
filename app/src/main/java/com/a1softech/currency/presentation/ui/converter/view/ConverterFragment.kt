package com.a1softech.currency.presentation.ui.converter.view

import android.util.Log
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.a1softech.currency.R
import com.a1softech.currency.data.database.history.HistoryEntity
import com.a1softech.currency.databinding.FragmentConverterBinding
import com.a1softech.currency.domain.model.CurrencyListModel
import com.a1softech.currency.presentation.base.NetworkResult
import com.a1softech.currency.presentation.base.view.BaseFragment
import com.a1softech.currency.presentation.ui.converter.viewmodel.ConverterState
import com.a1softech.currency.presentation.ui.converter.viewmodel.ConverterViewModel
import com.a1softech.currency.presentation.util.Constants
import com.a1softech.currency.presentation.util.MainBindingAdapter.Companion.atIndex
import com.a1softech.currency.presentation.util.MainBindingAdapter.Companion.setItems
import com.a1softech.currency.presentation.util.UiEvent
import com.a1softech.currency.presentation.util.getTimeInMills
import com.a1softech.currency.presentation.util.getTodayDate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_converter.view.*
import kotlinx.coroutines.flow.buffer


@AndroidEntryPoint
class ConverterFragment(override val layoutResourceLayout: Int = R.layout.fragment_converter) :
    BaseFragment<FragmentConverterBinding>() {

    private val viewModel by viewModels<ConverterViewModel>()
    private var fromCurrencyCode: String = ""
    private var toCurrencyCode: String = ""
    private var fromCurrencyId: Int = 0
    private var toCurrencyId: Int = 0
    private var amount = "1"
    private val currencyList: ArrayList<String> = arrayListOf()
    private val currencyListHashMap: HashMap<String, Double> = hashMapOf()
    private var currenciesSetInSpinner = false

    override fun onFragmentCreated(dataBinder: FragmentConverterBinding) {
        viewModel.fetchCurrencyList(Constants.access_key)
        setViewsListener()
    }

    private fun setViewsListener() {
        rootView.btn_swap.setOnClickListener { swapSpinnersValues() }

        rootView.from_selector.setOnItemClickListener { adapterView, view, position, l ->
            fromCurrencyId = position
            fromCurrencyCode = currencyList[position]

            if (toCurrencyCode != "") countConvertedValue()
        }

        rootView.to_selector.setOnItemClickListener { adapterView, view, position, l ->
            toCurrencyId = position
            toCurrencyCode = currencyList[position]

            if (fromCurrencyCode != "") countConvertedValue()
        }

        rootView.et_amount.doAfterTextChanged {
            amount = it.toString()
            if (fromCurrencyCode != "" && toCurrencyCode != "")
                countConvertedValue()
        }
    }

    private fun countConvertedValue() {
        var fromRate = 1.0
        currencyListHashMap[fromCurrencyCode]?.let {
            fromRate = it
        }
        var toRate = 1.0
        currencyListHashMap[toCurrencyCode]?.let {
            toRate = it
        }

        val convertedValue = String.format("%,.5f", toRate / fromRate * handleAmount(amount))
        rootView.et_converted.setText(convertedValue)


        saveCurrencyRecordToDataBase(convertedValue)
    }

    private fun saveCurrencyRecordToDataBase(convertedValue: String) {

        viewModel.saveCurrencyConvertRecord(
            HistoryEntity(
                fromCurrencyCode, toCurrencyCode, handleAmount(amount).toString(),
                convertedValue, getTodayDate(), getTimeInMills()
            )
        )
    }

    private fun handleAmount(amount: String): Int {
        return if (amount == "0" || amount.isEmpty())
            1
        else amount.toInt()
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
            is NetworkResult.ServerError -> UiEvent.ShowSnackBar("Server Error - ${result.message}")
            is NetworkResult.NetworkError -> UiEvent.ShowSnackBar("Network Error - ${result.message}")
            is NetworkResult.Loading -> {
            }
            is NetworkResult.Success -> handleCurrencyResponse(result.data)
        }
    }

    private fun handleCurrencyResponse(currencyListModel: CurrencyListModel?) {
        currencyListModel?.let {
            handleCurrencyList(it)
            if (!currenciesSetInSpinner) setCurrenciesInSpinners()
        }
    }

    private fun setCurrenciesInSpinners() {
        rootView.from_selector.setItems(currencyList)
        rootView.to_selector.setItems(currencyList)

        currenciesSetInSpinner = true
    }

    private fun swapSpinnersValues() {
        if (fromCurrencyCode.isEmpty() || toCurrencyCode.isEmpty()) return

        swapIndices()
        reloadDataToSpinners()
        countConvertedValue()
    }

    private fun swapIndices() {
        val idTemp = fromCurrencyId
        fromCurrencyId = toCurrencyId
        toCurrencyId = idTemp

        val codeTemp = fromCurrencyCode
        fromCurrencyCode = toCurrencyCode
        toCurrencyCode = codeTemp
    }

    private fun handleCurrencyList(it: CurrencyListModel) {
        it.rates?.let {
            it.AED?.let {
                currencyList.add("AED")
                currencyListHashMap["AED"] = it
            }
            it.AFN?.let {
                currencyList.add("AFN")
                currencyListHashMap["AFN"] = it
            }
            it.ALL?.let {
                currencyList.add("ALL")
                currencyListHashMap["ALL"] = it
            }
            it.AMD?.let {
                currencyList.add("AMD")
                currencyListHashMap["AMD"] = it
            }
            it.ANG?.let {
                currencyList.add("ANG")
                currencyListHashMap["ANG"] = it
            }
            it.AOA?.let {
                currencyList.add("AOA")
                currencyListHashMap["AOA"] = it
            }
            it.ARS?.let {
                currencyList.add("ARS")
                currencyListHashMap["ARS"] = it
            }
            it.AUD?.let {
                currencyList.add("AUD")
                currencyListHashMap["AUD"] = it
            }
            it.AWG?.let {
                currencyList.add("AWG")
                currencyListHashMap["AWG"] = it
            }
            it.AZN?.let {
                currencyList.add("AZN")
                currencyListHashMap["AZN"] = it
            }
            it.BAM?.let {
                currencyList.add("BAM")
                currencyListHashMap["BAM"] = it
            }
            it.BBD?.let {
                currencyList.add("BBD")
                currencyListHashMap["BBD"] = it
            }
            it.BDT?.let {
                currencyList.add("BDT")
                currencyListHashMap["BDT"] = it
            }
            it.BGN?.let {
                currencyList.add("BGN")
                currencyListHashMap["BGN"] = it
            }
            it.BHD?.let {
                currencyList.add("BHD")
                currencyListHashMap["BHD"] = it
            }
            it.BIF?.let {
                currencyList.add("BIF")
                currencyListHashMap["BIF"] = it
            }
            it.BMD?.let {
                currencyList.add("BMD")
                currencyListHashMap["BMD"] = it
            }
            it.BND?.let {
                currencyList.add("BND")
                currencyListHashMap["BND"] = it
            }
            it.BOB?.let {
                currencyList.add("BOB")
                currencyListHashMap["BOB"] = it
            }
            it.BRL?.let {
                currencyList.add("BRL")
                currencyListHashMap["BRL"] = it
            }
            it.BSD?.let {
                currencyList.add("BSD")
                currencyListHashMap["BSD"] = it
            }
            it.BTC?.let {
                currencyList.add("BTC")
                currencyListHashMap["BTC"] = it
            }
            it.BTN?.let {
                currencyList.add("BTN")
                currencyListHashMap["BTN"] = it
            }
            it.BWP?.let {
                currencyList.add("BWP")
                currencyListHashMap["BWP"] = it
            }
            it.BYN?.let {
                currencyList.add("BYN")
                currencyListHashMap["BYN"] = it
            }
            it.BYR?.let {
                currencyList.add("BYR")
                currencyListHashMap["BYR"] = it
            }
            it.BZD?.let {
                currencyList.add("BZD")
                currencyListHashMap["BZD"] = it
            }
            it.CAD?.let {
                currencyList.add("CAD")
                currencyListHashMap["CAD"] = it
            }
            it.CDF?.let {
                currencyList.add("CDF")
                currencyListHashMap["CDF"] = it
            }
            it.CHF?.let {
                currencyList.add("CHF")
                currencyListHashMap["CHF"] = it
            }
            it.CLF?.let {
                currencyList.add("CLF")
                currencyListHashMap["CLF"] = it
            }
            it.CLP?.let {
                currencyList.add("CLP")
                currencyListHashMap["CLP"] = it
            }
            it.CNY?.let {
                currencyList.add("CNY")
                currencyListHashMap["CNY"] = it
            }
            it.COP?.let {
                currencyList.add("COP")
                currencyListHashMap["COP"] = it
            }
            it.CRC?.let {
                currencyList.add("CRC")
                currencyListHashMap["CRC"] = it
            }
            it.CUC?.let {
                currencyList.add("CUC")
                currencyListHashMap["CUC"] = it
            }
            it.CUP?.let {
                currencyList.add("CUP")
                currencyListHashMap["CUP"] = it
            }
            it.CVE?.let {
                currencyList.add("CVE")
                currencyListHashMap["CVE"] = it
            }
            it.CZK?.let {
                currencyList.add("CZK")
                currencyListHashMap["CZK"] = it
            }
            it.DJF?.let {
                currencyList.add("DJF")
                currencyListHashMap["DJF"] = it
            }
            it.DKK?.let {
                currencyList.add("DKK")
                currencyListHashMap["DKK"] = it
            }
            it.DOP?.let {
                currencyList.add("DOP")
                currencyListHashMap["DOP"] = it
            }
            it.DZD?.let {
                currencyList.add("DZD")
                currencyListHashMap["DZD"] = it
            }
            it.EGP?.let {
                currencyList.add("EGP")
                currencyListHashMap["EGP"] = it
            }
            it.ERN?.let {
                currencyList.add("ERN")
                currencyListHashMap["ERN"] = it
            }
            it.ETB?.let {
                currencyList.add("ETB")
                currencyListHashMap["ETB"] = it
            }
            it.EUR?.let {
                currencyList.add("EUR")
                currencyListHashMap["EUR"] = it
            }
            it.FJD?.let {
                currencyList.add("FJD")
                currencyListHashMap["FJD"] = it
            }
            it.FKP?.let {
                currencyList.add("FKP")
                currencyListHashMap["FKP"] = it
            }
            it.GBP?.let {
                currencyList.add("GBP")
                currencyListHashMap["GBP"] = it
            }
            it.GEL?.let {
                currencyList.add("GEL")
                currencyListHashMap["GEL"] = it
            }
            it.GGP?.let {
                currencyList.add("GGP")
                currencyListHashMap["GGP"] = it
            }
            it.GHS?.let {
                currencyList.add("GHS")
                currencyListHashMap["GHS"] = it
            }
            it.GIP?.let {
                currencyList.add("GIP")
                currencyListHashMap["GIP"] = it
            }
            it.GMD?.let {
                currencyList.add("GMD")
                currencyListHashMap["GMD"] = it
            }
            it.GNF?.let {
                currencyList.add("GNF")
                currencyListHashMap["GNF"] = it
            }
            it.GTQ?.let {
                currencyList.add("GTQ")
                currencyListHashMap["GTQ"] = it
            }
            it.GYD?.let {
                currencyList.add("GYD")
                currencyListHashMap["GYD"] = it
            }
            it.HKD?.let {
                currencyList.add("HKD")
                currencyListHashMap["HKD"] = it
            }
            it.HNL?.let {
                currencyList.add("HNL")
                currencyListHashMap["HNL"] = it
            }
            it.HRK?.let {
                currencyList.add("HRK")
                currencyListHashMap["HRK"] = it
            }
            it.HTG?.let {
                currencyList.add("HTG")
                currencyListHashMap["HTG"] = it
            }
            it.HUF?.let {
                currencyList.add("HUF")
                currencyListHashMap["HUF"] = it
            }
            it.IDR?.let {
                currencyList.add("IDR")
                currencyListHashMap["IDR"] = it
            }
            it.ILS?.let {
                currencyList.add("ILS")
                currencyListHashMap["ILS"] = it
            }
            it.IMP?.let {
                currencyList.add("IMP")
                currencyListHashMap["IMP"] = it
            }
            it.INR?.let {
                currencyList.add("INR")
                currencyListHashMap["INR"] = it
            }
            it.IQD?.let {
                currencyList.add("IQD")
                currencyListHashMap["IQD"] = it
            }
            it.IRR?.let {
                currencyList.add("IRR")
                currencyListHashMap["IRR"] = it
            }
            it.ISK?.let {
                currencyList.add("ISK")
                currencyListHashMap["ISK"] = it
            }
            it.JEP?.let {
                currencyList.add("JEP")
                currencyListHashMap["JEP"] = it
            }
            it.JMD?.let {
                currencyList.add("JMD")
                currencyListHashMap["JMD"] = it
            }
            it.JOD?.let {
                currencyList.add("JOD")
                currencyListHashMap["JOD"] = it
            }
            it.JPY?.let {
                currencyList.add("JPY")
                currencyListHashMap["JPY"] = it
            }
            it.KES?.let {
                currencyList.add("KES")
                currencyListHashMap["KES"] = it
            }
            it.KGS?.let {
                currencyList.add("KGS")
                currencyListHashMap["KGS"] = it
            }
            it.KHR?.let {
                currencyList.add("KHR")
                currencyListHashMap["KHR"] = it
            }
            it.KMF?.let {
                currencyList.add("KMF")
                currencyListHashMap["KMF"] = it
            }
            it.KPW?.let {
                currencyList.add("KPW")
                currencyListHashMap["KPW"] = it
            }
            it.KRW?.let {
                currencyList.add("KRW")
                currencyListHashMap["KRW"] = it
            }
            it.KWD?.let {
                currencyList.add("KWD")
                currencyListHashMap["KWD"] = it
            }
            it.KYD?.let {
                currencyList.add("KYD")
                currencyListHashMap["KYD"] = it
            }
            it.KZT?.let {
                currencyList.add("KZT")
                currencyListHashMap["KZT"] = it
            }
            it.LAK?.let {
                currencyList.add("LAK")
                currencyListHashMap["LAK"] = it
            }
            it.LBP?.let {
                currencyList.add("LBP")
                currencyListHashMap["LBP"] = it
            }
            it.LKR?.let {
                currencyList.add("LKR")
                currencyListHashMap["LKR"] = it
            }
            it.LRD?.let {
                currencyList.add("LRD")
                currencyListHashMap["LRD"] = it
            }
            it.LSL?.let {
                currencyList.add("LSL")
                currencyListHashMap["LSL"] = it
            }
            it.LTL?.let {
                currencyList.add("LTL")
                currencyListHashMap["LTL"] = it
            }
            it.LVL?.let {
                currencyList.add("LVL")
                currencyListHashMap["LVL"] = it
            }
            it.LYD?.let {
                currencyList.add("LYD")
                currencyListHashMap["LYD"] = it
            }
            it.MAD?.let {
                currencyList.add("MAD")
                currencyListHashMap["MAD"] = it
            }
            it.MDL?.let {
                currencyList.add("MDL")
                currencyListHashMap["MDL"] = it
            }
            it.MGA?.let {
                currencyList.add("MGA")
                currencyListHashMap["MGA"] = it
            }
            it.MKD?.let {
                currencyList.add("MKD")
                currencyListHashMap["MKD"] = it
            }
            it.MMK?.let {
                currencyList.add("MMK")
                currencyListHashMap["MMK"] = it
            }
            it.MNT?.let {
                currencyList.add("MNT")
                currencyListHashMap["MNT"] = it
            }
            it.MOP?.let {
                currencyList.add("MOP")
                currencyListHashMap["MOP"] = it
            }
            it.MRO?.let {
                currencyList.add("MRO")
                currencyListHashMap["MRO"] = it
            }
            it.MUR?.let {
                currencyList.add("MUR")
                currencyListHashMap["MUR"] = it
            }
            it.MVR?.let {
                currencyList.add("MVR")
                currencyListHashMap["MVR"] = it
            }
            it.MWK?.let {
                currencyList.add("MWK")
                currencyListHashMap["MWK"] = it
            }
            it.MXN?.let {
                currencyList.add("MXN")
                currencyListHashMap["MXN"] = it
            }
            it.MYR?.let {
                currencyList.add("MYR")
                currencyListHashMap["MYR"] = it
            }
            it.MZN?.let {
                currencyList.add("MZN")
                currencyListHashMap["MZN"] = it
            }
            it.NAD?.let {
                currencyList.add("NAD")
                currencyListHashMap["NAD"] = it
            }
            it.NGN?.let {
                currencyList.add("NGN")
                currencyListHashMap["NGN"] = it
            }
            it.NIO?.let {
                currencyList.add("NIO")
                currencyListHashMap["NIO"] = it
            }
            it.NOK?.let {
                currencyList.add("NOK")
                currencyListHashMap["NOK"] = it
            }
            it.NPR?.let {
                currencyList.add("NPR")
                currencyListHashMap["NPR"] = it
            }
            it.NZD?.let {
                currencyList.add("NZD")
                currencyListHashMap["NZD"] = it
            }
            it.OMR?.let {
                currencyList.add("OMR")
                currencyListHashMap["OMR"] = it
            }
            it.PAB?.let {
                currencyList.add("PAB")
                currencyListHashMap["PAB"] = it
            }
            it.PEN?.let {
                currencyList.add("PEN")
                currencyListHashMap["PEN"] = it
            }
            it.PGK?.let {
                currencyList.add("PGK")
                currencyListHashMap["PGK"] = it
            }
            it.PHP?.let {
                currencyList.add("PHP")
                currencyListHashMap["PHP"] = it
            }
            it.PKR?.let {
                currencyList.add("PKR")
                currencyListHashMap["PKR"] = it
            }
            it.PLN?.let {
                currencyList.add("PLN")
                currencyListHashMap["PLN"] = it
            }
            it.PYG?.let {
                currencyList.add("PYG")
                currencyListHashMap["PYG"] = it
            }
            it.QAR?.let {
                currencyList.add("QAR")
                currencyListHashMap["QAR"] = it
            }
            it.RON?.let {
                currencyList.add("RON")
                currencyListHashMap["RON"] = it
            }
            it.RSD?.let {
                currencyList.add("RSD")
                currencyListHashMap["RSD"] = it
            }
            it.RUB?.let {
                currencyList.add("RUB")
                currencyListHashMap["RUB"] = it
            }
            it.RWF?.let {
                currencyList.add("RWF")
                currencyListHashMap["RWF"] = it
            }
            it.SAR?.let {
                currencyList.add("SAR")
                currencyListHashMap["SAR"] = it
            }
            it.SBD?.let {
                currencyList.add("SBD")
                currencyListHashMap["SBD"] = it
            }
            it.SCR?.let {
                currencyList.add("SCR")
                currencyListHashMap["SCR"] = it
            }
            it.SDG?.let {
                currencyList.add("SDG")
                currencyListHashMap["SDG"] = it
            }
            it.SEK?.let {
                currencyList.add("SEK")
                currencyListHashMap["SEK"] = it
            }
            it.SGD?.let {
                currencyList.add("SGD")
                currencyListHashMap["SGD"] = it
            }
            it.SHP?.let {
                currencyList.add("SHP")
                currencyListHashMap["SHP"] = it
            }
            it.SLL?.let {
                currencyList.add("SLL")
                currencyListHashMap["SLL"] = it
            }
            it.SOS?.let {
                currencyList.add("SOS")
                currencyListHashMap["SOS"] = it
            }
            it.SRD?.let {
                currencyList.add("SRD")
                currencyListHashMap["SRD"] = it
            }
            it.STD?.let {
                currencyList.add("STD")
                currencyListHashMap["STD"] = it
            }
            it.SVC?.let {
                currencyList.add("SVC")
                currencyListHashMap["SVC"] = it
            }
            it.SYP?.let {
                currencyList.add("SYP")
                currencyListHashMap["SYP"] = it
            }
            it.SZL?.let {
                currencyList.add("SZL")
                currencyListHashMap["SZL"] = it
            }
            it.THB?.let {
                currencyList.add("THB")
                currencyListHashMap["THB"] = it
            }
            it.TJS?.let {
                currencyList.add("TJS")
                currencyListHashMap["TJS"] = it
            }
            it.TMT?.let {
                currencyList.add("TMT")
                currencyListHashMap["TMT"] = it
            }
            it.TND?.let {
                currencyList.add("TND")
                currencyListHashMap["TND"] = it
            }
            it.TOP?.let {
                currencyList.add("TOP")
                currencyListHashMap["TOP"] = it
            }
            it.TRY?.let {
                currencyList.add("TRY")
                currencyListHashMap["TRY"] = it
            }
            it.TTD?.let {
                currencyList.add("TTD")
                currencyListHashMap["TTD"] = it
            }
            it.TWD?.let {
                currencyList.add("TWD")
                currencyListHashMap["TWD"] = it
            }
            it.TZS?.let {
                currencyList.add("TZS")
                currencyListHashMap["TZS"] = it
            }
            it.UAH?.let {
                currencyList.add("UAH")
                currencyListHashMap["UAH"] = it
            }
            it.UGX?.let {
                currencyList.add("UGX")
                currencyListHashMap["UGX"] = it
            }
            it.USD?.let {
                currencyList.add("USD")
                currencyListHashMap["USD"] = it
            }
            it.UYU?.let {
                currencyList.add("UYU")
                currencyListHashMap["UYU"] = it
            }
            it.UZS?.let {
                currencyList.add("UZS")
                currencyListHashMap["UZS"] = it
            }
            it.VEF?.let {
                currencyList.add("VEF")
                currencyListHashMap["VEF"] = it
            }
            it.VND?.let {
                currencyList.add("VND")
                currencyListHashMap["VND"] = it
            }
            it.VUV?.let {
                currencyList.add("VUV")
                currencyListHashMap["VUV"] = it
            }
            it.WST?.let {
                currencyList.add("WST")
                currencyListHashMap["WST"] = it
            }
            it.XAF?.let {
                currencyList.add("XAF")
                currencyListHashMap["XAF"] = it
            }
            it.XAG?.let {
                currencyList.add("XAG")
                currencyListHashMap["XAG"] = it
            }
            it.XAU?.let {
                currencyList.add("XAU")
                currencyListHashMap["XAU"] = it
            }
            it.XCD?.let {
                currencyList.add("XCD")
                currencyListHashMap["XCD"] = it
            }
            it.XDR?.let {
                currencyList.add("XDR")
                currencyListHashMap["XDR"] = it
            }
            it.XOF?.let {
                currencyList.add("XOF")
                currencyListHashMap["XOF"] = it
            }
            it.XPF?.let {
                currencyList.add("XPF")
                currencyListHashMap["XPF"] = it
            }
            it.YER?.let {
                currencyList.add("YER")
                currencyListHashMap["YER"] = it
            }
            it.ZAR?.let {
                currencyList.add("ZAR")
                currencyListHashMap["ZAR"] = it
            }
            it.ZMK?.let {
                currencyList.add("ZMK")
                currencyListHashMap["ZMK"] = it
            }
            it.ZMW?.let {
                currencyList.add("ZMW")
                currencyListHashMap["ZMW"] = it
            }
            it.ZWL?.let {
                currencyList.add("ZWL")
                currencyListHashMap["ZWL"] = it
            }

            Log.d("TAG", "handleCurrencyList: $it")
            Log.d("TAG", "handleCurrencyList: ${it.EGP}")
            Log.d("TAG", "handleCurrencyList: ${it.USD}")
            Log.d("TAG", "handleCurrencyList: ${currencyListHashMap["EGP"]}")
            Log.d("TAG", "handleCurrencyList: ${currencyListHashMap["USD"]}")
        }
    }

    override fun onPause() {
        super.onPause()
        clearSpinnersValues()
    }

    override fun onResume() {
        super.onResume()
        reloadDataToSpinners()
    }

    private fun reloadDataToSpinners() {
        rootView.from_selector.atIndex(fromCurrencyId)
        rootView.to_selector.atIndex(toCurrencyId)
    }

    private fun clearSpinnersValues() {
        rootView.from_selector.setText("", false)
        rootView.to_selector.setText("", false)
    }
}