package com.example.fintrack.list.data

import com.bitcoinprice.BitcoinPriceResponse
import retrofit2.Call
import retrofit2.http.GET


//interface ApiService {
//}




interface ApiService {
    @GET("v1/bpi/currentprice.json")
    fun getBitcoinPrice(): Call<BitcoinPriceResponse>
}