package com.gopal.photoexplorer.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.gopal.photoexplorer.R
import com.gopal.photoexplorer.databinding.ActivityMainBinding
import com.gopal.photoexplorer.ui.viewmodel.PhotoViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val viewModel: PhotoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        setTheme(R.style.Theme_PhotoExplorer)

    }

    private fun setTitle() {
        viewModel.title.observe(this) {
            if (!it.isNullOrEmpty()) {
                _binding.textViewTitle.text = it
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setTitle()
    }
}

