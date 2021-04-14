package com.example.ayobantu.data.model

import android.os.Message

class ActionState <T>(
    val data: T? = null,
    val message: String? = null,
    val isSuccess: Boolean = true,
    var isConsumed: Boolean = false

)