package com.example.fintrack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.example.fintrack.list.presentation.ui.BitcoinPriceViewModel
import com.example.fintrack.list.presentation.ui.SplashScreen
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<BitcoinPriceViewModel> { BitcoinPriceViewModel.Factory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        setContent{

            SplashScreen()
        }
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





