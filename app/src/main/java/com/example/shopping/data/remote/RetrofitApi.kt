package com.example.ayobantu.data.remote

import android.icu.util.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    const val FOOD_URL = "https://masak-apa.tomorisakura.vercel.app"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .readTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
        .connectTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
        .build()

    private fun create(url: String) : Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return  retrofit
    }

    fun foodService() : FoodService{
        return create(FOOD_URL).create(FoodService::class.java)
    }
}
