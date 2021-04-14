package com.example.ayobantu.ui.food

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import com.example.ayobantu.R
import com.example.ayobantu.databinding.FragmentFoodBinding
import com.example.ayobantu.ui.home.MainActivity

class FoodFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentFoodBinding
    private val viewModel: FoodViewModel by lazy { FoodViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodBinding.inflate(inflater, container, false).apply {
            viewModel = this@FoodFragment.viewModel
            lifecycleOwner = this@FoodFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.recycleView.adapter = FoodAdapter(parent)
        viewModel.listFood()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listFood()
        }
    }
    private fun observe() {
    viewModel.loading.observe(viewLifecycleOwner){
    binding.swipeRefresh.isRefreshing = it
    }
        viewModel.actionState.observe(viewLifecycleOwner){
            if (it.isConsumed) {
                Log.i("ActionState", "isConsume")
            } else if(!it.isSuccess) {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }

    }
}