package com.example.fintrack.common.data

import android.util.Log
import com.example.fintrack.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL: String = "https://api.blockchain.com/v3/exchange/"


object RetrofitClient {

    private val httpClient: OkHttpClient
        get() {
            val clientBuilder = OkHttpClient.Builder()
            val token = BuildConfig.API_KEY

            clientBuilder.addInterceptor { chain ->
                val original: Request = chain.request()
                val requestBuilder: Request.Builder =
                    original.newBuilder().header("X-API-Token", "Bearer $token")
                val request: Request = requestBuilder.build()
                Log.d("API_TEST", "Request Header: ${request.header("X-API-Token")}")
                chain.proceed(request)
            }
            return clientBuilder.build()
        }

    val retrofitInstance: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(httpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()

}