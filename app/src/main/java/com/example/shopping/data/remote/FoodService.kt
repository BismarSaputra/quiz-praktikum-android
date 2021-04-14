package com.example.ayobantu.data.remote

import com.example.ayobantu.data.model.FoodList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodService {
   @GET("api/categorys/article/makanan-gaya-hidup")
   fun listFood() : Call<FoodList>

   @GET("detail/")
   fun detailFood(@Query("url") url: String) : Call<FoodList>

   @GET("search/")
   fun searchFood(@Query("q") query: String) : Call<FoodList>
}