package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.number.observe(this, Observer {
            binding.textView.text = it.toString()
            if (it == 0){
                binding.reset.visibility = View.GONE
            } else {
                binding.reset.visibility = View.VISIBLE
            }
        })
        binding.buttonMinus.setOnClickListener {
            viewModel.add()

        }
        binding.buttonPlus.setOnClickListener {
            viewModel.minus()

        }
        binding.reset.setOnClickListener {
            viewModel.reset()

        }
    }
}