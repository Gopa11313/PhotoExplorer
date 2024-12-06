package com.gopal.photoexplorer.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gopal.photoexplorer.R
import com.gopal.photoexplorer.databinding.ActivityMainBinding
import com.gopal.photoexplorer.ui.viewmodel.StoreViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: StoreViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTheme(R.style.Theme_PhotoExplorer)

    }

    private fun setTitle() {
        viewModel.title.observe(this) {
            if (!it.isNullOrEmpty()) {
                binding.textViewTitle.text = it
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setTitle()
    }
}

