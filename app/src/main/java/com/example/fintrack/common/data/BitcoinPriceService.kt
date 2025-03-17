package com.example.fintrack.common.data

import com.example.fintrack.common.model.BitcoinPriceResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface BitcoinPriceService {
    @GET("tickers/BTC-USD")
    suspend fun getBitcoinPrice(): Response<BitcoinPriceResponse>
}