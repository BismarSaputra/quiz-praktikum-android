package com.example.ayobantu.ui.food

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.ayobantu.R
import com.example.ayobantu.data.model.Food
import com.example.ayobantu.databinding.ItemFoodBinding
import com.example.ayobantu.ui.base.BaseAdapter

class FoodAdapter (val context: Context): BaseAdapter<Food>(R.layout.item_food) {
    override fun onBind(binding: ViewDataBinding?, data: Food) {
        val mBinding = binding as ItemFoodBinding
        Glide.with(context).load(data.thumb).into(mBinding.itemThumb)
    }

    override fun onClick(binding: ViewDataBinding?, data: Food) {
        val intent =  Intent(context, FoodActivity::class.java)
        intent.putExtra(FoodActivity.OPEN_FOOD, data)
        context.startActivity(intent)
    }
}