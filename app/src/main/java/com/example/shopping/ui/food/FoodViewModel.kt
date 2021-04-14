package com.example.ayobantu.ui.food

import android.app.DownloadManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ayobantu.data.model.ActionState
import com.example.ayobantu.data.model.Food
import com.example.ayobantu.data.repository.FoodRepository
import kotlinx.coroutines.launch

class FoodViewModel : ViewModel() {
 private val repo: FoodRepository by lazy { FoodRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Food>>()
    val detailResp = MutableLiveData<Food>()
    val searchResp = MutableLiveData<List<Food>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listFood(){
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listfood()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailFood(url: String? = this.url.value){
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailFood(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchFood(query: String? =  this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchFood(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}