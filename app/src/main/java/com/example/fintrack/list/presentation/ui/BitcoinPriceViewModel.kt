package com.example.fintrack.list.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.fintrack.common.data.BitcoinPriceService
import com.example.fintrack.common.data.RetrofitClient
import com.example.fintrack.common.model.BitcoinPriceResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create

class BitcoinPriceViewModel(
     listService: BitcoinPriceService
) : ViewModel() {

    private val _bitcoinPrice = MutableStateFlow<BitcoinPriceResponse?>(null)
    val bitcoinPrice: StateFlow<BitcoinPriceResponse?> = _bitcoinPrice

    private val apiService: BitcoinPriceService =
        RetrofitClient.retrofitInstance.create(BitcoinPriceService::class.java)

    init {
        Log.d("API_TEST", "ViewModel Init")
        fetchBitcoinPrice()
    }

    private fun fetchBitcoinPrice() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = apiService.getBitcoinPrice()
            if (response.isSuccessful) {
                _bitcoinPrice.value = response.body()
                Log.d("API_TEST", "Success: ${response.body()}")
            } else {
                Log.e("API_TEST", "Error: ${response.errorBody()?.string()}")
            }
        }
    }
    companion object {
        val Factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val listService = RetrofitClient.retrofitInstance.create(BitcoinPriceService::class.java)
                return BitcoinPriceViewModel(
                    listService
                ) as T
            }
        }
    }
}

