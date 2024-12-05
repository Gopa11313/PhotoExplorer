package com.gopal.photoexplorer.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gopal.photoexplorer.R
import com.gopal.photoexplorer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        setTheme(R.style.Theme_PhotoExplorer)

    }
}

