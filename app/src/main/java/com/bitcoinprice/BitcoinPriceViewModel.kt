package com.bitcoinprice

//import android.telecom.Call
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
//import com.example.fintrack.common.model.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BitcoinPriceViewModel(function: NavHostController, viewModel: () -> Unit) : ViewModel() {


    private val _bitcoinPrice = MutableStateFlow<BitcoinPriceResponse?>(null)
    val bitcoinPrice: StateFlow<BitcoinPriceResponse?> = _bitcoinPrice

    private val apiService: BitcoinPriceService =
        RetrofitClient.retrofitInstance.create(BitcoinPriceService::class.java)

    init {
        Log.d("API_TEST", "ViewModel Init")
        fetchBitcoinPrice()
    }

    private fun fetchBitcoinPrice() {
        viewModelScope.launch {
            apiService.getBitcoinPrice().enqueue(object : Callback<BitcoinPriceResponse> {
                override fun onResponse(call: Call<BitcoinPriceResponse>, response: Response<BitcoinPriceResponse>
                ) {
                    if (response.isSuccessful) {
                        _bitcoinPrice.value = response.body()
                        Log.d("API_TEST", "Success: ${response.body()}")
                    } else {
                        Log.e("API_TEST", "Error: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<BitcoinPriceResponse>, t: Throwable) {
                    Log.e("API_TEST", "Error: ${t.message}")
                }
            })
        }
    }

}