package com.bitcoinprice

import retrofit2.http.GET

interface BitcoinPriceService {
    @GET("/tickers/BTC-USD")
    fun getBitcoinPrice(): BitcoinPriceResponse
}