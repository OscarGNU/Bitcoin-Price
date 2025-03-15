package com.bitcoinprice

import retrofit2.Call
import retrofit2.http.GET

interface BitcoinPriceService {
    @GET("tickers/BTC-USD")
    fun getBitcoinPrice(): Call<BitcoinPriceResponse>
}