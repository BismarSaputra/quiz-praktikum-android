package com.example.ayobantu.ui.auth

import android.content.ComponentCallbacks
import android.content.Context
import com.example.ayobantu.data.model.ActionState
import com.example.ayobantu.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object AyobantuAuth {
    fun logout(context: Context, callback: ((ActionState<Boolean>)->Unit)? = null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch{
            val resp = repo.logout()
            withContext(Dispatchers.Main){
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}