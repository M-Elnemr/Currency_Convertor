package com.a1softech.currency.data.dto

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class CurrencyListModelDto(
    @Json(name = "base") val base: String?,
    @Json(name = "date") val date: String?,
    @Json(name = "rates") val rates: Rates?,
    @Json(name = "success") val success: Boolean?,
    @Json(name = "timestamp") val timestamp: Int?
)

@JsonSerializable
data class Rates(
    @Json(name = "AED") val AED: Double?,
    @Json(name = "AFN") val AFN: Double?,
    @Json(name = "ALL") val ALL: Double?,
    @Json(name = "AMD") val AMD: Double?,
    @Json(name = "ANG") val ANG: Double?,
    @Json(name = "AOA") val AOA: Double?,
    @Json(name = "ARS") val ARS: Double?,
    @Json(name = "AUD") val AUD: Double?,
    @Json(name = "AWG") val AWG: Double?,
    @Json(name = "AZN") val AZN: Double?,
    @Json(name = "BAM") val BAM: Double?,
    @Json(name = "BBD") val BBD: Double?,
    @Json(name = "BDT") val BDT: Double?,
    @Json(name = "BGN") val BGN: Double?,
    @Json(name = "BHD") val BHD: Double?,
    @Json(name = "BIF") val BIF: Double?,
    @Json(name = "BMD") val BMD: Double?,
    @Json(name = "BND") val BND: Double?,
    @Json(name = "BOB") val BOB: Double?,
    @Json(name = "BRL") val BRL: Double?,
    @Json(name = "BSD") val BSD: Double?,
    @Json(name = "BTC") val BTC: Double?,
    @Json(name = "BTN") val BTN: Double?,
    @Json(name = "BWP") val BWP: Double?,
    @Json(name = "BYN") val BYN: Double?,
    @Json(name = "BYR") val BYR: Double?,
    @Json(name = "BZD") val BZD: Double?,
    @Json(name = "CAD") val CAD: Double?,
    @Json(name = "CDF") val CDF: Double?,
    @Json(name = "CHF") val CHF: Double?,
    @Json(name = "CLF") val CLF: Double?,
    @Json(name = "CLP") val CLP: Double?,
    @Json(name = "CNY") val CNY: Double?,
    @Json(name = "COP") val COP: Double?,
    @Json(name = "CRC") val CRC: Double?,
    @Json(name = "CUC") val CUC: Double?,
    @Json(name = "CUP") val CUP: Double?,
    @Json(name = "CVE") val CVE: Double?,
    @Json(name = "CZK") val CZK: Double?,
    @Json(name = "DJF") val DJF: Double?,
    @Json(name = "DKK") val DKK: Double?,
    @Json(name = "DOP") val DOP: Double?,
    @Json(name = "DZD") val DZD: Double?,
    @Json(name = "EGP") val EGP: Double?,
    @Json(name = "ERN") val ERN: Double?,
    @Json(name = "ETB") val ETB: Double?,
    @Json(name = "EUR") val EUR: Int?,
    @Json(name = "FJD") val FJD: Double?,
    @Json(name = "FKP") val FKP: Double?,
    @Json(name = "GBP") val GBP: Double?,
    @Json(name = "GEL") val GEL: Double?,
    @Json(name = "GGP") val GGP: Double?,
    @Json(name = "GHS") val GHS: Double?,
    @Json(name = "GIP") val GIP: Double?,
    @Json(name = "GMD") val GMD: Double?,
    @Json(name = "GNF") val GNF: Double?,
    @Json(name = "GTQ") val GTQ: Double?,
    @Json(name = "GYD") val GYD: Double?,
    @Json(name = "HKD") val HKD: Double?,
    @Json(name = "HNL") val HNL: Double?,
    @Json(name = "HRK") val HRK: Double?,
    @Json(name = "HTG") val HTG: Double?,
    @Json(name = "HUF") val HUF: Double?,
    @Json(name = "IDR") val IDR: Double?,
    @Json(name = "ILS") val ILS: Double?,
    @Json(name = "IMP") val IMP: Double?,
    @Json(name = "INR") val INR: Double?,
    @Json(name = "IQD") val IQD: Double?,
    @Json(name = "IRR") val IRR: Double?,
    @Json(name = "ISK") val ISK: Double?,
    @Json(name = "JEP") val JEP: Double?,
    @Json(name = "JMD") val JMD: Double?,
    @Json(name = "JOD") val JOD: Double?,
    @Json(name = "JPY") val JPY: Double?,
    @Json(name = "KES") val KES: Double?,
    @Json(name = "KGS") val KGS: Double?,
    @Json(name = "KHR") val KHR: Double?,
    @Json(name = "KMF") val KMF: Double?,
    @Json(name = "KPW") val KPW: Double?,
    @Json(name = "KRW") val KRW: Double?,
    @Json(name = "KWD") val KWD: Double?,
    @Json(name = "KYD") val KYD: Double?,
    @Json(name = "KZT") val KZT: Double?,
    @Json(name = "LAK") val LAK: Double?,
    @Json(name = "LBP") val LBP: Double?,
    @Json(name = "LKR") val LKR: Double?,
    @Json(name = "LRD") val LRD: Double?,
    @Json(name = "LSL") val LSL: Double?,
    @Json(name = "LTL") val LTL: Double?,
    @Json(name = "LVL") val LVL: Double?,
    @Json(name = "LYD") val LYD: Double?,
    @Json(name = "MAD") val MAD: Double?,
    @Json(name = "MDL") val MDL: Double?,
    @Json(name = "MGA") val MGA: Double?,
    @Json(name = "MKD") val MKD: Double?,
    @Json(name = "MMK") val MMK: Double?,
    @Json(name = "MNT") val MNT: Double?,
    @Json(name = "MOP") val MOP: Double?,
    @Json(name = "MRO") val MRO: Double?,
    @Json(name = "MUR") val MUR: Double?,
    @Json(name = "MVR") val MVR: Double?,
    @Json(name = "MWK") val MWK: Double?,
    @Json(name = "MXN") val MXN: Double?,
    @Json(name = "MYR") val MYR: Double?,
    @Json(name = "MZN") val MZN: Double?,
    @Json(name = "NAD") val NAD: Double?,
    @Json(name = "NGN") val NGN: Double?,
    @Json(name = "NIO") val NIO: Double?,
    @Json(name = "NOK") val NOK: Double?,
    @Json(name = "NPR") val NPR: Double?,
    @Json(name = "NZD") val NZD: Double?,
    @Json(name = "OMR") val OMR: Double?,
    @Json(name = "PAB") val PAB: Double?,
    @Json(name = "PEN") val PEN: Double?,
    @Json(name = "PGK") val PGK: Double?,
    @Json(name = "PHP") val PHP: Double?,
    @Json(name = "PKR") val PKR: Double?,
    @Json(name = "PLN") val PLN: Double?,
    @Json(name = "PYG") val PYG: Double?,
    @Json(name = "QAR") val QAR: Double?,
    @Json(name = "RON") val RON: Double?,
    @Json(name = "RSD") val RSD: Double?,
    @Json(name = "RUB") val RUB: Double?,
    @Json(name = "RWF") val RWF: Double?,
    @Json(name = "SAR") val SAR: Double?,
    @Json(name = "SBD") val SBD: Double?,
    @Json(name = "SCR") val SCR: Double?,
    @Json(name = "SDG") val SDG: Double?,
    @Json(name = "SEK") val SEK: Double?,
    @Json(name = "SGD") val SGD: Double?,
    @Json(name = "SHP") val SHP: Double?,
    @Json(name = "SLL") val SLL: Double?,
    @Json(name = "SOS") val SOS: Double?,
    @Json(name = "SRD") val SRD: Double?,
    @Json(name = "STD") val STD: Double?,
    @Json(name = "SVC") val SVC: Double?,
    @Json(name = "SYP") val SYP: Double?,
    @Json(name = "SZL") val SZL: Double?,
    @Json(name = "THB") val THB: Double?,
    @Json(name = "TJS") val TJS: Double?,
    @Json(name = "TMT") val TMT: Double?,
    @Json(name = "TND") val TND: Double?,
    @Json(name = "TOP") val TOP: Double?,
    @Json(name = "TRY") val TRY: Double?,
    @Json(name = "TTD") val TTD: Double?,
    @Json(name = "TWD") val TWD: Double?,
    @Json(name = "TZS") val TZS: Double?,
    @Json(name = "UAH") val UAH: Double?,
    @Json(name = "UGX") val UGX: Double?,
    @Json(name = "USD") val USD: Double?,
    @Json(name = "UYU") val UYU: Double?,
    @Json(name = "UZS") val UZS: Double?,
    @Json(name = "VEF") val VEF: Double?,
    @Json(name = "VND") val VND: Double?,
    @Json(name = "VUV") val VUV: Double?,
    @Json(name = "WST") val WST: Double?,
    @Json(name = "XAF") val XAF: Double?,
    @Json(name = "XAG") val XAG: Double?,
    @Json(name = "XAU") val XAU: Double?,
    @Json(name = "XCD") val XCD: Double?,
    @Json(name = "XDR") val XDR: Double?,
    @Json(name = "XOF") val XOF: Double?,
    @Json(name = "XPF") val XPF: Double?,
    @Json(name = "YER") val YER: Double?,
    @Json(name = "ZAR") val ZAR: Double?,
    @Json(name = "ZMK") val ZMK: Double?,
    @Json(name = "ZMW") val ZMW: Double?,
    @Json(name = "ZWL") val ZWL: Double?
)