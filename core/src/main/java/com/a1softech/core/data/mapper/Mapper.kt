package com.a1softech.core.data.mapper

import com.a1softech.core.data.database.history.HistoryEntity
import com.a1softech.core.data.dto.CurrencyListModelDto
import com.a1softech.core.domain.model.CurrencyListModel
import com.a1softech.core.domain.model.HistoryModel
import com.a1softech.core.domain.model.Rates
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun currencyMapper(dto: CurrencyListModelDto): CurrencyListModel {
        return CurrencyListModel(
            base = dto.base,
            date = dto.date,
            rates = dto.rates?.let {
                Rates(
                    AED = dto.rates.AED,
                    AFN = dto.rates.AFN,
                    ALL = dto.rates.ALL,
                    AMD = dto.rates.AMD,
                    ANG = dto.rates.ANG,
                    AOA = dto.rates.AOA,
                    ARS = dto.rates.ARS,
                    AUD = dto.rates.AUD,
                    AWG = dto.rates.AWG,
                    AZN = dto.rates.AZN,
                    BAM = dto.rates.BAM,
                    BBD = dto.rates.BBD,
                    BDT = dto.rates.BDT,
                    BGN = dto.rates.BGN,
                    BHD = dto.rates.BHD,
                    BIF = dto.rates.BIF,
                    BMD = dto.rates.BMD,
                    BND = dto.rates.BND,
                    BOB = dto.rates.BOB,
                    BRL = dto.rates.BRL,
                    BSD = dto.rates.BSD,
                    BTC = dto.rates.BTC,
                    BTN = dto.rates.BTN,
                    BWP = dto.rates.BWP,
                    BYN = dto.rates.BYN,
                    BYR = dto.rates.BYR,
                    BZD = dto.rates.BZD,
                    CAD = dto.rates.CAD,
                    CDF = dto.rates.CDF,
                    CHF = dto.rates.CHF,
                    CLF = dto.rates.CLF,
                    CLP = dto.rates.CLP,
                    CNY = dto.rates.CNY,
                    COP = dto.rates.COP,
                    CRC = dto.rates.CRC,
                    CUC = dto.rates.CUC,
                    CUP = dto.rates.CUP,
                    CVE = dto.rates.CVE,
                    CZK = dto.rates.CZK,
                    DJF = dto.rates.DJF,
                    DKK = dto.rates.DKK,
                    DOP = dto.rates.DOP,
                    DZD = dto.rates.DZD,
                    EGP = dto.rates.EGP,
                    ERN = dto.rates.ERN,
                    ETB = dto.rates.ETB,
                    EUR = dto.rates.EUR,
                    FJD = dto.rates.FJD,
                    FKP = dto.rates.FKP,
                    GBP = dto.rates.GBP,
                    GEL = dto.rates.GEL,
                    GGP = dto.rates.GGP,
                    GHS = dto.rates.GHS,
                    GIP = dto.rates.GIP,
                    GMD = dto.rates.GMD,
                    GNF = dto.rates.GNF,
                    GTQ = dto.rates.GTQ,
                    GYD = dto.rates.GYD,
                    HKD = dto.rates.HKD,
                    HNL = dto.rates.HNL,
                    HRK = dto.rates.HRK,
                    HTG = dto.rates.HTG,
                    HUF = dto.rates.HUF,
                    IDR = dto.rates.IDR,
                    ILS = dto.rates.ILS,
                    IMP = dto.rates.IMP,
                    INR = dto.rates.INR,
                    IQD = dto.rates.IQD,
                    IRR = dto.rates.IRR,
                    ISK = dto.rates.ISK,
                    JEP = dto.rates.JEP,
                    JMD = dto.rates.JMD,
                    JOD = dto.rates.JOD,
                    JPY = dto.rates.JPY,
                    KES = dto.rates.KES,
                    KGS = dto.rates.KGS,
                    KHR = dto.rates.KHR,
                    KMF = dto.rates.KMF,
                    KPW = dto.rates.KPW,
                    KRW = dto.rates.KRW,
                    KWD = dto.rates.KWD,
                    KYD = dto.rates.KYD,
                    KZT = dto.rates.KZT,
                    LAK = dto.rates.LAK,
                    LBP = dto.rates.LBP,
                    LKR = dto.rates.LKR,
                    LRD = dto.rates.LRD,
                    LSL = dto.rates.LSL,
                    LTL = dto.rates.LTL,
                    LVL = dto.rates.LVL,
                    LYD = dto.rates.LYD,
                    MAD = dto.rates.MAD,
                    MDL = dto.rates.MDL,
                    MGA = dto.rates.MGA,
                    MKD = dto.rates.MKD,
                    MMK = dto.rates.MMK,
                    MNT = dto.rates.MNT,
                    MOP = dto.rates.MOP,
                    MRO = dto.rates.MRO,
                    MUR = dto.rates.MUR,
                    MVR = dto.rates.MVR,
                    MWK = dto.rates.MWK,
                    MXN = dto.rates.MXN,
                    MYR = dto.rates.MYR,
                    MZN = dto.rates.MZN,
                    NAD = dto.rates.NAD,
                    NGN = dto.rates.NGN,
                    NIO = dto.rates.NIO,
                    NOK = dto.rates.NOK,
                    NPR = dto.rates.NPR,
                    NZD = dto.rates.NZD,
                    OMR = dto.rates.OMR,
                    PAB = dto.rates.PAB,
                    PEN = dto.rates.PEN,
                    PGK = dto.rates.PGK,
                    PHP = dto.rates.PHP,
                    PKR = dto.rates.PKR,
                    PLN = dto.rates.PLN,
                    PYG = dto.rates.PYG,
                    QAR = dto.rates.QAR,
                    RON = dto.rates.RON,
                    RSD = dto.rates.RSD,
                    RUB = dto.rates.RUB,
                    RWF = dto.rates.RWF,
                    SAR = dto.rates.SAR,
                    SBD = dto.rates.SBD,
                    SCR = dto.rates.SCR,
                    SDG = dto.rates.SDG,
                    SEK = dto.rates.SEK,
                    SGD = dto.rates.SGD,
                    SHP = dto.rates.SHP,
                    SLL = dto.rates.SLL,
                    SOS = dto.rates.SOS,
                    SRD = dto.rates.SRD,
                    STD = dto.rates.STD,
                    SVC = dto.rates.SVC,
                    SYP = dto.rates.SYP,
                    SZL = dto.rates.SZL,
                    THB = dto.rates.THB,
                    TJS = dto.rates.TJS,
                    TMT = dto.rates.TMT,
                    TND = dto.rates.TND,
                    TOP = dto.rates.TOP,
                    TRY = dto.rates.TRY,
                    TTD = dto.rates.TTD,
                    TWD = dto.rates.TWD,
                    TZS = dto.rates.TZS,
                    UAH = dto.rates.UAH,
                    UGX = dto.rates.UGX,
                    USD = dto.rates.USD,
                    UYU = dto.rates.UYU,
                    UZS = dto.rates.UZS,
                    VEF = dto.rates.VEF,
                    VND = dto.rates.VND,
                    VUV = dto.rates.VUV,
                    WST = dto.rates.WST,
                    XAF = dto.rates.XAF,
                    XAG = dto.rates.XAG,
                    XAU = dto.rates.XAU,
                    XCD = dto.rates.XCD,
                    XDR = dto.rates.XDR,
                    XOF = dto.rates.XOF,
                    XPF = dto.rates.XPF,
                    YER = dto.rates.YER,
                    ZAR = dto.rates.ZAR,
                    ZMK = dto.rates.ZMK,
                    ZMW = dto.rates.ZMW,
                    ZWL = dto.rates.ZWL
                )

            }
        )
    }

    fun historyMapper(entity: List<HistoryEntity>): List<HistoryModel>{
        return entity.map {
            HistoryModel(
                it.currencyFrom,
                it.currencyTo,
                it.amount,
                it.convertedValue,
                it.date,
                it.timeInMillis
            )
        }
    }
}
