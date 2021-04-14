package com.example.ayobantu.ui.food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ayobantu.R

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
    }
    companion object {
        const val OPEN_FOOD = "open_food"
    }
}