package com.example.fintrack.common.model

/*data class BitcoinPriceResponse(
    val symbol: String,
    val price_24h: Double,
    val volume_24h: Double,
    val last_trade_price: Double
    )*/

data class BitcoinPriceResponse(
    val time: Time,
    val bpi: Bpi
)

data class Time(val updated: String)

data class Bpi(val USD: Currency)

data class Currency(
    val code: String,
    val rate: String,
    val description: String
)