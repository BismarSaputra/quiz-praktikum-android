package com.example.ayobantu.data.repository

import com.example.ayobantu.data.model.ActionState
import com.example.ayobantu.data.model.Food
import com.example.ayobantu.data.remote.FoodService
import com.example.ayobantu.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class FoodRepository {
    private val foodService: FoodService by lazy { RetrofitApi.foodService() }

    suspend fun  listfood() : ActionState<List<Food>> {
        return try {
            val list = foodService.listFood().await()
            ActionState(list.results)
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailFood(url: String) : ActionState<Food> {
       return try {
            val list = foodService.detailFood(url).await()
            ActionState(list.results.first())
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchFood(query: String) : ActionState<List<Food>> {
       return try {
            val list = foodService.searchFood(query).await()
            ActionState(list.results)
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}