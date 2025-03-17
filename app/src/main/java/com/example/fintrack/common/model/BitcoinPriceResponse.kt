package com.example.fintrack.common.model

data class BitcoinPriceResponse(
    val symbol: String,
    val price_24h: Double,
    val volume_24h: Double,
    val last_trade_price: Double
    )