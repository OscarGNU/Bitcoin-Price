package com.bitcoinprice

import android.health.connect.datatypes.units.Volume

data class BitcoinPriceResponse(
    val symbol: String,
    val price: Double,
    val volume: Double,
    val tradePrice: Double
    )