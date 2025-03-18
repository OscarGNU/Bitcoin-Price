package com.example.fintrack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.fintrack.list.presentation.ui.BitcoinPriceViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<BitcoinPriceViewModel> { BitcoinPriceViewModel.Factory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("API_TEST", "MainActivity test!")

        lifecycleScope.launch {
            viewModel.bitcoinPrice.collectLatest { price_24h ->
                if (price_24h != null) {
                    Log.d("API_TEST", "Received Price: $price_24h")
                }
            }
        }

    }
}





